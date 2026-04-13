import java.sql.*;

public class java_14633_JDBCQueryHandler_A03 {

    // Define a private static variable for database connection
    private static Connection conn = null;

    // Define a private static variable for statement
    private static Statement stmt = null;

    // Define a private static variable for result set
    private static ResultSet rs = null;

    // Function to connect to the database
    public static void connectToDB(String dbUrl, String user, String password) {
        try {
            conn = DriverManager.getConnection(dbUrl, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to execute SQL Query
    public static void executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
            processResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to process the result set
    public static void processResultSet() {
        try {
            while (rs.next()) {
                // Print each column value
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Function to close the connection
    public static void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Connect to the database
        connectToDB("jdbc:mysql://localhost/test", "root", "password");
        
        // Execute a query
        executeQuery("SELECT id, name FROM test_table");

        // Close the connection
        closeConnection();
    }
}