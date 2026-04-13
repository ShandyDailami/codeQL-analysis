import java.sql.*;

public class java_35300_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Create a statement
            stmt = conn.createStatement();

            // Step 3: Execute a SQL Query
            String sql = "SELECT * FROM Users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Handle the ResultSet
            while (rs.next()) {
                System.out.println("User found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}