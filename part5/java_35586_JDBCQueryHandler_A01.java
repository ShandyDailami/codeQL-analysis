import java.sql.*;
import java.util.Properties;

public class java_35586_JDBCQueryHandler_A01 {

    private Connection conn;

    public void connect(String url, String username, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", username);
            props.setProperty("password", password);

            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("Query result: " + rs.getString("columnName"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();
        jdbcHandler.connect("jdbc:your_database_url", "username", "password");
        jdbcHandler.executeQuery("SELECT * FROM your_table");
        jdbcHandler.disconnect();
    }
}