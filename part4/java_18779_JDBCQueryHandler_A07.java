import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18779_JDBCQueryHandler_A07 {

    private String url;
    private String username;
    private String password;
    private Connection conn;

    public java_18779_JDBCQueryHandler_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String query) {
        Statement stmt = null;
        int rowsUpdated = 0;
        try {
            stmt = conn.createStatement();
            rowsUpdated = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsUpdated;
    }

    public static void main(String[] args) {
        // Connect to the database
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/test", "username", "password");
        jdbcQueryHandler.connect();

        // Execute a query
        String query = "SELECT * FROM users";
        ResultSet rs = jdbcQueryHandler.executeQuery(query);

        // Process the result set
        while (rs.next()) {
            String name = rs.getString("name");
            // Process the name
        }

        // Disconnect from the database
        jdbcQueryHandler.disconnect();
    }
}