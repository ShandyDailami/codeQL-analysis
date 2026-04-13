import java.sql.*;

public class java_07261_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a SQL query
            rs = stmt.executeQuery("SELECT * FROM A08_IntegrityFailure");

            // Step 4: Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("name"));
            }

            // Step 5: Close the connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}