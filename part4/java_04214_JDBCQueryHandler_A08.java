import java.sql.*;
import java.util.Properties;

public class java_04214_JDBCQueryHandler_A08 {
    private Connection conn;

    public java_04214_JDBCQueryHandler_A08(String url, String username, String password) throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        this.conn = DriverManager.getConnection(url, props);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
    }

    public void close() throws SQLException {
        conn.close();
    }
}

// Usage
try {
    JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_database", "username", "password");

    ResultSet rs = handler.executeQuery("SELECT * FROM your_table");
    while (rs.next()) {
        // Process the result set
    }

    handler.close();
} catch (SQLException e) {
    e.printStackTrace();
}