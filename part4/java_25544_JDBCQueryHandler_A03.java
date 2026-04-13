import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25544_JDBCQueryHandler_A03 {

    // URL, username, and password for your database
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Loading the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connecting to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Executing the query
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM my_table"); // replace this with your query

            // Step 4: Processing the ResultSet
            while (rs.next()) {
                // Extract data from result set
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // Print the extracted data
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Closing the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}