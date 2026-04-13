import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19311_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection string
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "root";

            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);

            // Perform a simple query
            String sql = "SELECT * FROM myTable";
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);

            // Process the ResultSet
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
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