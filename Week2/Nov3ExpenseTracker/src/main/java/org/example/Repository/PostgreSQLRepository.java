package org.example.Repository;

import java.sql.*;
import java.util.List;

import org.example.Expense;
import org.example.Repository.IRepository;

public class PostgreSQLRepository implements IRepository {
    // Fields
    private static final String Postgre_URL = "jdbc:postgresql://localhost:5432/expensesdb";
    private static final String Postgre_User = "postgres";
    private static final String Postgre_Password = "postgres";
    private static final String Postgre_PW = "mysecretpassword";

    private Connection connection;

    // Constructor
    public PostgreSQLRepository() {
        try {
            connection = DriverManager.getConnection(Postgre_URL, Postgre_User, Postgre_PW);
            try (Statement stmt = connection.createStatement()) {
                String sql = "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                        "CREATE TABLE IF NOT EXISTS ExpenseReport.Expenses (" +
                        "id INT PRIMARY KEY," +
                        "date TIMESTAMP NOT NULL," +
                        "price FLOAT CHECK (price > 0)," +
                        "merchant VARCHAR(50) NOT NULL" +
                        ");";

                stmt.execute(sql);
                System.out.println("Successful creation of H2 database!");
            }
        } catch (SQLException e){
            e.printStackTrace(); //print out error of where it occurred. What actually created this error?
        }
    }

    @Override
    public void createExpense(Expense expense) {
        String sql = "INSERT INTO ExpenseReport.Expenses (id, date, price, merchant) VALUES ( ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, expense.getId());
            stmt.setDate(2, new java.sql.Date(expense.getDate().getTime()));
            stmt.setDouble(3, expense.getValue());
            stmt.setString(4, expense.getMerchant());
            stmt.executeUpdate();
            System.out.println("Expense successfully created!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Expense readExpense(int id) {
//        String sql = "SELECT * FROM ExpenseReport.Expenses WHERE id = ?;";
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//
//                int foundID = rs.getInt("id");
//                Date date = rs.getDate("date");
//                double price = rs.getDouble("price");
//                String merchant = rs.getString("merchant");
//
//                return new Expense(foundID, date, price, merchant);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return null;
    }

    @Override
    public void updateExpense(Expense expense) {
//        String sql = "UPDATE ExpenseReport.Expenses SET date = ?, price = ?, merchant = ? WHERE id = ?;";


    }

    @Override
    public void deleteExpense(int id) {

    }

    @Override
    public List<Expense> loadExpenses() {
        return List.of();
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {

    }

    // Methods


}
