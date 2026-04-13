import java.sql.*;

public class java_41282_JDBCQueryHandler_A08 {

    // Define the database connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection conn;

    // Connect to the database
    public static void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute an SQL INSERT statement
    public static void insert(String table, String columns, String values) {
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES (" + values + ")";
        execute(sql);
    }

    // Execute an SQL SELECT statement
    public static ResultSet select(String table, String columns, String conditions) {
        String sql = "SELECT " + columns + " FROM " + table + " WHERE " + conditions;
        return executeQuery(sql);
    }

    // Execute an SQL UPDATE statement
    public static void update(String table, String set, String conditions) {
        String sql = "UPDATE " + table + " SET " + set + " WHERE " + conditions;
        execute(sql);
    }

    // Execute an SQL DELETE statement
    public static void delete(String table, String conditions) {
        String sql = "DELETE FROM " + table + " WHERE " + conditions;
        execute(sql);
    }

    // Execute an SQL statement
    private static void execute(String sql) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute an SQL query
    private static ResultSet executeQuery(String sql) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // Connect to the database
        connect();

        // Insert a row into the table
        insert("students", "name, age", "'John, 20'");

        // Select all rows from the table
        ResultSet rs = select("students", "*", "age > 20");
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
        }

        // Update a row in the table
        update("students", "age = 21", "name = 'John'");

        // Delete a row from the table
        delete("students", "age = 21");
    }
}