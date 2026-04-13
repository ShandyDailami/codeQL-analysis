import java.sql.*;

public class java_22333_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Setup connection parameters
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Perform a query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");

            // Process the results
            while (rs.next()) {
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Close the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC connection: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found: " + e.getMessage());
        }
    }
}