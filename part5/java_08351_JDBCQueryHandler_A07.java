import java.sql.*;

public class java_08351_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public java_08351_JDBCQueryHandler_A07() {
        // Database credentials
        String dbName = "your_database";
        String dbUser = "your_user";
        String dbPassword = "your_password";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + dbName + "?user=" + dbUser + "&password=" + dbPassword);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
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
            if (rs != null) {
                rs.close();
            }
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
}