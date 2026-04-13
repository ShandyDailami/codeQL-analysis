import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33501_JDBCQueryHandler_A03 {

    private String url;
    private String username;
    private String password;

    public java_33501_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:your_database_url", "your_username", "your_password");
        Connection conn = queryHandler.getConnection();
        if (conn != null) {
            // Here you can add your SQL queries
            // For example: conn.createStatement().executeUpdate("your_sql_query");
        }
        queryHandler.closeConnection(conn);
    }
}