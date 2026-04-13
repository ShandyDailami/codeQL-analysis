import java.sql.*;

public class java_00886_JDBCQueryHandler_A07 {

    // URLs for the database
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Create the statement
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '"
                    + args[0] + "' AND password = '" + args[1] + "'");

            // Print out the results
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}