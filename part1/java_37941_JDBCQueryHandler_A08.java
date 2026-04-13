import java.sql.*;

public class java_37941_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    // open a connection
    public java_37941_JDBCQueryHandler_A08(String dbURL, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, user, password);
        this.stmt = conn.createStatement();
    }

    // execute a SELECT query
    public ResultSet select(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    // execute a UPDATE, DELETE, or INSERT query
    public int manipulate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    // close the connection
    public void close() throws SQLException {
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) {
        try {
            // replace with your database URL, username, and password
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "root", "password");

            // Example of a SELECT query
            ResultSet rs = handler.select("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            // Example of a DELETE query
            handler.manipulate("DELETE FROM users WHERE name = 'John'");

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}