import java.sql.*;

public class java_10882_JDBCQueryHandler_A01 {

    private Connection conn = null;
    private Statement stmt = null;

    private final String url = "jdbc:mysql://localhost:3306/testdb";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String username = "root";
    private final String password = "password";

    public java_10882_JDBCQueryHandler_A01() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler();

        ResultSet rs = jdbcHandler.executeQuery("SELECT * FROM Users");

        try {
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcHandler.closeConnection();
        }
    }
}