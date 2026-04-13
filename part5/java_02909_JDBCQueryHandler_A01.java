import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.RowSet;
import java.sql.SQLException;

public class java_02909_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Get connection to database
            DataSource ds = getDataSource();
            Connection conn = ds.getConnection(USER, PASSWORD);

            // Execute SQL query
            String sql = "SELECT * FROM employees";
            ResultSet rs = conn.createStatement().executeQuery(sql);

            // Handle result set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // Handle row here
            }

            // Clean up
            rs.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static DataSource getDataSource() {
        ComboPooledPool cp = new ComboPooledPool();
        return cp.getConnectionPool();
    }
}