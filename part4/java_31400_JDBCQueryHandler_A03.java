import java.sql.*;

public class java_31400_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_31400_JDBCQueryHandler_A03(String dbUrl, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "root", "password");
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