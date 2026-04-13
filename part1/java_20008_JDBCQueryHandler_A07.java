import java.sql.*;

public class java_20008_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");

            // Create a statement
            Statement stmt = conn.createStatement();

            // Define the SQL query
            String query = "SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            // Close the connection
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}