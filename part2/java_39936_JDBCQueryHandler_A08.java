import java.sql.*;

public class java_39936_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a SQL Query
            String sql = "SELECT * FROM Users WHERE role = 'Admin'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the Result Set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Email: " + email);
            }

            // Step 5: Close the ResultSet and Statement
            rs.close();
            stmt.close();

            // Step 6: Close the Connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}