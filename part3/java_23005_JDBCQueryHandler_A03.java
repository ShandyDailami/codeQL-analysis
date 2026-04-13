import java.sql.*;

public class java_23005_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            stmt = conn.createStatement();

            // Start with a secure SQL query
            String sql = "SELECT * FROM users WHERE email = '" +
                    // Prepare the SQL Injection here
                    "' AND password = '" +
                    // Prepare the SQL Injection here
                    "'";

            // Execute the query
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Access the ResultSet data
                System.out.println(rs.getString("email") + " " + rs.getString("password"));
            }

            // Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
            e.printStackTrace();
        }
    }
}