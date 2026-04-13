import java.sql.*;

public class java_25642_JDBCQueryHandler_A01 {
    private Connection conn;

    public java_25642_JDBCQueryHandler_A01(String dbURL, String userName, String password) throws SQLException {
        this.conn = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");

            ResultSet rs = handler.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}