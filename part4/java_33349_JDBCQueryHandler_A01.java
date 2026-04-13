import java.sql.*;

public class java_33349_JDBCQueryHandler_A01 {
    public static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    public static final String USER = "root";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a SQL query
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 6: Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the connections
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}