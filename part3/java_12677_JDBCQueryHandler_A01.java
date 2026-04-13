import java.sql.*;

public class java_12677_JDBCQueryHandler_A01 {
    private Connection connection;

    public java_12677_JDBCQueryHandler_A01(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            // Here, you can handle the error in a real-world scenario
        }
    }

    public void performSecureOperation() {
        // Assume we have a table called "Users" with columns "id", "username", "password"
        String query = "SELECT * FROM Users WHERE username = 'admin' AND password = 'password'";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Here, you should handle the result in a real-world scenario
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Here, you can handle the error in a real-world scenario
        }
    }

    public static void main(String[] args) {
        // Here, you can handle the main method in a real-world scenario
        // You can create the connection, perform the secure operation, and close the connection
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler(dbUrl, username, password);
        handler.performSecureOperation();
    }
}