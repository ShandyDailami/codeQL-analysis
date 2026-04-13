import java.sql.*;

public class java_01881_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + args[0] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
            }

            // Step 5: Clean up
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found: " + e);
        }
    }
}