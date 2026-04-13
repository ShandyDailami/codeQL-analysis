import java.sql.*;

public class java_39930_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_39930_JDBCQueryHandler_A07(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        return stmt.executeQuery();
    }

    public int executeUpdate(String query, Object... params) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        return stmt.executeUpdate();
    }

    public void close() throws SQLException {
        conn.close();
    }
}

// Usage

String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
String user = "myuser";
String password = "mypassword";

try {
    JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, user, password);

    ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = ? AND password = ?", "user1", "password1");

    while (rs.next()) {
        System.out.println("User: " + rs.getString("username"));
    }

    handler.close();
} catch (SQLException e) {
    e.printStackTrace();
}