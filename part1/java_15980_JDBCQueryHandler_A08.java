import java.sql.*;

public class java_15980_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE ID = " + 1;
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error processing SQL statement: " + e.getMessage());
        }
    }
}