import java.sql.*;

public class java_29809_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Establish a Connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 2: Create a Statement
            stmt = conn.createStatement();

            // Step 3: Execute a SQL Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM my_table");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}