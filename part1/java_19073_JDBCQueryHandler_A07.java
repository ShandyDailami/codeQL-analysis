import java.sql.*;

public class java_19073_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    public java_19073_JDBCQueryHandler_A07(String dbURL, String user, String password) throws SQLException {
        try {
            conn = DriverManager.getConnection(dbURL, user, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw e;
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "myuser";
            String password = "mypassword";
            new JDBCQueryHandler(dbURL, user, password);

            String query = "SELECT * FROM users";
            ResultSet rs = ((JDBCQueryHandler) (new JDBCQueryHandler(dbURL, user, password))).executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            ((JDBCQueryHandler) (new JDBCQueryHandler(dbURL, user, password))).closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}