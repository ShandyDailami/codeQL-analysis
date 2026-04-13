import java.sql.*;

public class java_01416_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_01416_JDBCQueryHandler_A01() {
        try {
            // Step 1: Establish the connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 3: Execute the query
            rs = stmt.executeQuery(query);

            // Print out the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Clean up
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler().executeQuery("SELECT * FROM users");
    }
}