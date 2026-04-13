import java.sql.*;

public class java_15268_JDBCQueryHandler_A08 {

    private Connection conn;
    private Statement stmt;

    public java_15268_JDBCQueryHandler_A08(String dbURL, String username, String password) {
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet result = null;
        try {
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int executeUpdate(String query) {
        int result = 0;
        try {
            result = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
        JDBCQueryHandler jdbcHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        ResultSet result = jdbcHandler.executeQuery("SELECT * FROM Users");
        while (result.next()) {
            System.out.println(result.getString("username"));
        }
        jdbcHandler.closeConnection();
    }
}