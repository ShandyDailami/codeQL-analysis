import java.sql.*;

public class java_06768_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Connect to the database
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Create a statement object
            Statement stmt = con.createStatement();

            // Define the SQL query
            String query = "SELECT * FROM yourTable";

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
                System.out.println();
            }

            // Close the result set and statement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}