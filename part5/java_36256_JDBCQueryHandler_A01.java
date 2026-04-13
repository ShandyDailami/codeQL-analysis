import java.sql.*;

public class java_36256_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Prepare the SQL query
            String query = "SELECT * FROM users WHERE role='admin'";

            // Step 3: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Step 5: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Name: " + name);
                System.out.println("Role: " + role);
            }

            // Step 6: Close the connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}