import java.sql.*;

public class java_33139_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a query
            String sql = "SELECT * FROM my_table WHERE id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setInt(1, 123); // Replace 123 with the id you're interested in

            ResultSet rs = preparedStmt.executeQuery();

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("name"));
            }

            // Step 5: Clean up
            rs.close();
            preparedStmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}