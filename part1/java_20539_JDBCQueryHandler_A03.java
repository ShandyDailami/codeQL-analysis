import java.sql.*;

public class java_20539_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_20539_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, userName, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(url, username, password);
            ResultSet result = handler.executeQuery("SELECT * FROM users");

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

            handler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}