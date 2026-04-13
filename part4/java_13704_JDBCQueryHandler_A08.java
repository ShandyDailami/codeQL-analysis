import java.sql.*;

public class java_13704_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection conn;

    public static void main(String[] args) {
        connectDB();
        runQuery();
        closeDB();
    }

    private static void connectDB() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Connection failed. Error: " + e.getMessage());
        }
    }

    private static void runQuery() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Query failed. Error: " + e.getMessage());
        }
    }

    private static void closeDB() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            System.out.println("Error while closing the database. Error: " + e.getMessage());
        }
    }
}