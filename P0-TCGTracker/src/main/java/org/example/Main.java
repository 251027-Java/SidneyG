package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
        // Option 1: pass a specific card id
        ShowMarketPrice.main(new String[] { "swsh4-25" });

        // OR if you refactored ShowMarketPrice to expose a helper:
        // ShowMarketPrice.show("swsh4-25");
    }
}
