import java.sql.*;

public class java_04245_SessionManager_A03 {
    private static Connection conn;

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // 1. Establish the database connection
            conn = DriverManager.getConnection(url, username, password);

            // 2. Execute a SQL statement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            if (rs.next()) {
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Invalid credentials!");
            }

            // 3. Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}