import java.sql.*;

public class java_16613_JDBCQueryHandler_A07 {

    private Connection conn = null;
    private Statement stmt = null;

    // Establish a connection to the database.
    public void connect(String url, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
            this.stmt = this.conn.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Execute a SELECT query.
    public ResultSet executeSelectQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    // Execute a INSERT, UPDATE or DELETE query.
    public int executeUpdateQuery(String query) {
        int count = 0;
        try {
            count = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    // Close the connection.
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.connect("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        ResultSet rs = handler.executeSelectQuery("SELECT * FROM users");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        handler.close();
    }
}