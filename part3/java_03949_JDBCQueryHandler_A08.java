import java.sql.*;

public class java_03949_JDBCQueryHandler_A08 {
    // Database credentials
    private static final String USER = "username";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 2: Create a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM MyTable");

            // Step 4: Process the result
            while (rs.next()) {
                System.out.println(rs.getString("MyColumn"));
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}