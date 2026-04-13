import java.sql.*;

public class java_26144_JDBCQueryHandler_A03 {

    private Connection conn;
    private PreparedStatement stmt;

    public java_26144_JDBCQueryHandler_A03(String dbUrl, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbUrl, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        stmt = conn.prepareStatement(query);
        return stmt.executeQuery();
    }

    public void closeConnection() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "password";

        try {
            JDBCQueryHandler handler = new JDBCQueryHandler(dbUrl, userName, password);
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