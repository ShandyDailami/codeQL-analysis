import java.sql.*;
import java.util.Properties;

public class java_29980_JDBCQueryHandler_A03 {
    private Connection conn;
    private Statement stmt;

    public java_29980_JDBCQueryHandler_A03(String url, String username, String password) {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);

        try {
            conn = DriverManager.getConnection(url, props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // handle the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQueryAndReturn(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int update(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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
}