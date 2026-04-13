import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32640_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connections
            if (rs != null) try { rs.close(); } catch (SQLException e) {}
            if (stmt != null) try { stmt.close(); } catch (SQLException e) {}
            if (conn != null) try { conn.close(); } catch (SQLException e) {}
        }
    }
}