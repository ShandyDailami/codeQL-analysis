import java.sql.*;

public class java_09939_JDBCQueryHandler_A08 {
    private static Connection conn = null;
    private static Statement stmt = null;

    static void connect(String dbname, String username, String password) {
        String url = "jdbc:mysql://localhost:3306/" + dbname;
        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    static ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return null;
        }
    }

    static void executeUpdate(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    static void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connect("mydatabase", "myusername", "mypassword");
        ResultSet resultSet = executeQuery("SELECT * FROM mytable");
        while (resultSet.next()) {
            // Process the result set
        }
        closeConnection();
    }
}