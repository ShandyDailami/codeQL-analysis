import java.sql.*;

public class java_33656_JDBCQueryHandler_A01 {

    // BrokenAccessControlHandler.java
    public static void main(String[] args) {
        // Insecure database connection configuration
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "user";
        String password = "password";

        try {
            // Establish the database connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Execute a secure operation (for example, SELECT query)
            String query = "SELECT * FROM Users";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print the results
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}