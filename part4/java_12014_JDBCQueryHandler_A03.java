import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12014_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Execute a statement
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the results
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Clean up
            if (rs != null) try { rs.close(); } catch (SQLException e) { /*ignore*/ }
            if (stmt != null) try { stmt.close(); } catch (SQLException e) { /*ignore*/ }
            if (conn != null) try { conn.close(); } catch (SQLException e) { /*ignore*/ }
        }
    }
}