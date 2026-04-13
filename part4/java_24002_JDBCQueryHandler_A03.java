import java.sql.*;

public class java_24002_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Prepare a statement
            String query = "SELECT * FROM mytable";
            Statement stmt = conn.createStatement();

            // Step 3: Execute the statement
            ResultSet rs = stmt.executeQuery(query);

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 5: Close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}