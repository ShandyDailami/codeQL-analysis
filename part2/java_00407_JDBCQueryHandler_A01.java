import java.sql.*;

public class java_00407_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();

            // Step 2: Execute SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = 'admin'");

            // Step 3: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 4: Close the ResultSet and the connection
            rs.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}