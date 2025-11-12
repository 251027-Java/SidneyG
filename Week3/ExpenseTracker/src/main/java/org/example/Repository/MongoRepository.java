package org.example.Repository;

import com.mongodb.client.model.*;
import org.example.Expense;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.*;
import org.bson.Document;



public class MongoRepository implements IRepository {

//    docker run -d \
//            --name MongoRepositoryDB \
//            -p 27017:27017 \
//            -v ~/mongodb/data:/data/db \
//            -e MONGO_INITDB_ROOT_USERNAME=admin \
//            -e MONGO_INITDB_ROOT_PASSWORD=password \
//    mongo:latest

    // Fields
                                            // "[language]://[username]:[password]@[host]/[database]?[options]
    private static final String MONGO_URI = "mongodb://admin:password@localhost:27017/expensesdb?authSource=admin";
    private final MongoCollection<Document> expensesCollection;

// These are all variables that can be written directly instead of established as a variable
    //private static final String COLLECTION_NAME = "expenses";
    //private static final String DB_NAME = "expensesdb";
    //private final MongoClient client;
    //private final MongoDatabase db;

    // Constructor
    public MongoRepository() {
                MongoClient client = MongoClients.create(MONGO_URI);
                MongoDatabase db = client.getDatabase("expensesdb");
                this.expensesCollection = db.getCollection("expenses");

                System.out.println("Connected to MongoDB!");
            }



//    private Expense fromDoc(Document d) {
//        if (d == null) return null;
//        return new Expense(
//                d.getInteger("id"),
//                d.getDate("date"),
//                d.getDouble("price"),
//                d.getString("merchant")
//        );
//    }


    // Methods
    //Deserialize
    private Expense documentToExpense(Document doc) {
        return new Expense( doc.getInteger("_id" ),
                            doc.getDate("date"),
                            doc.getDouble("value"),
                            doc.getString("merchant"));
    }

    //Serialize
    private Document expenseToDocument(Expense expense) {
        return new Document("_id", expense.getId())
                    .append("date", expense.getDate())
                    .append("value", expense.getValue())
                    .append("merchant", expense.getMerchant());
    }

    @Override
    public void createExpense(Expense expense) {
        Document expenseDoc = expenseToDocument(expense);
        expensesCollection.insertOne(expenseDoc);
    }

    @Override
    public Expense readExpense(int id) {
        Document doc = expensesCollection.find(Filters.eq("_id", id)).first();
        return (doc != null) ? documentToExpense(doc) : null;
    }

    @Override
    public void updateExpense(Expense expense) {
        Document doc = expenseToDocument(expense);
        expensesCollection.updateOne(Filters.eq("_id", expense.getId()), doc);
    }

    @Override
    public void deleteExpense(int id) {
        expensesCollection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();

       for (Document doc : expensesCollection.find()) {
           expenses.add(documentToExpense(doc));
       }
       return expenses;
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {

    }
}
