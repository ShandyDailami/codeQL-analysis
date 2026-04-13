import java.sql.*;

public class java_08635_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            connectDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void connectDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection(URL, USER, PASS);

        // Start a new transaction
        conn.setAutoCommit(false);

        // Run a query that should fail due to lack of permissions
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users WHERE username = 'baduser'");

        // Handle the ResultSet if necessary
        if (rs.next()) {
            System.out.println("User found, attempting to access sensitive data");
            // Access the sensitive data here
            // For simplicity, just print the data
            System.out.println("Username: " + rs.getString("username"));
            System.out.println("Password: " + rs.getString("password"));
        } else {
            System.out.println("User not found");
        }

        // Close the connection
        conn.close();

        // Ensure the transaction is committed
        conn.commit();
    }
}