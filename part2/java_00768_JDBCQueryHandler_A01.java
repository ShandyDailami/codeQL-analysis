import java.sql.*;

public class java_00768_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_00768_JDBCQueryHandler_A01(String dbUrl, String username, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl, username, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";
            JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, username, password);

            String query = "SELECT * FROM Users";
            ResultSet rs = handler.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}