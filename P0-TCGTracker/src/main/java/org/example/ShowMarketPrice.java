package org.example;

import okhttp3.*;
import com.google.gson.*;
import java.time.Duration;
import java.util.Collections;

public class ShowMarketPrice {
    private static final String BASE = "https://api.pokemontcg.io/v2";
    private static final Gson G = new GsonBuilder().setPrettyPrinting().create();

    private static final OkHttpClient HTTP = new OkHttpClient.Builder()
            .connectTimeout(Duration.ofSeconds(20))
            .readTimeout(Duration.ofSeconds(30))
            .writeTimeout(Duration.ofSeconds(20))
            .callTimeout(Duration.ofSeconds(45))
            // Some networks/proxies have issues with HTTP/2; force 1.1:
            .protocols(Collections.singletonList(Protocol.HTTP_1_1))
            .build();

    public static void main(String[] args) throws Exception {
        String apiKey = System.getenv("POKEMONTCG_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("POKEMONTCG_API_KEY not set");
        }

        String id = (args != null && args.length > 0) ? args[0] : "swsh4-25"; // Charizard example
        String url = BASE + "/cards/" + id;

        Request req = new Request.Builder()
                .url(url)
                .addHeader("X-Api-Key", apiKey)
                .addHeader("Accept", "application/json")
                .addHeader("User-Agent", "P0-TCGTracker/1.0 (+okhttp)")
                .build();

        String body = executeWithOneRetry(req);
        JsonObject root = JsonParser.parseString(body).getAsJsonObject();
        JsonObject card = root.getAsJsonObject("data");

        String name = card.get("name").getAsString();
        String setName = card.getAsJsonObject("set").get("name").getAsString();

        // TCGplayer -> prices.normal.market (USD)
        Double marketUsd = null;
        if (card.has("tcgplayer")) {
            JsonObject tp = card.getAsJsonObject("tcgplayer");
            if (tp.has("prices")) {
                JsonObject prices = tp.getAsJsonObject("prices");
                // You may also check "holofoil", "reverseHolofoil", etc.
                if (prices.has("normal")) {
                    JsonObject normal = prices.getAsJsonObject("normal");
                    if (normal.has("market") && !normal.get("market").isJsonNull()) {
                        marketUsd = normal.get("market").getAsDouble();
                    }
                }
            }
        }

        System.out.printf("%s — %s%n", name, setName);
        System.out.println("TCGplayer market (USD): " + (marketUsd != null ? marketUsd : "(not available)"));
    }

    private static String executeWithOneRetry(Request req) throws Exception {
        try (Response res = HTTP.newCall(req).execute()) {
            if (!res.isSuccessful()) throw new RuntimeException("HTTP " + res.code() + ": " + (res.body() != null ? res.body().string() : ""));
            return res.body().string();
        } catch (java.net.SocketTimeoutException e) {
            // one quick retry
            try (Response res = HTTP.newCall(req).execute()) {
                if (!res.isSuccessful()) throw new RuntimeException("HTTP " + res.code() + ": " + (res.body() != null ? res.body().string() : ""));
                return res.body().string();
            }
        }
    }
}
