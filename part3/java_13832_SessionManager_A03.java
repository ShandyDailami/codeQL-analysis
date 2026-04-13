import java.sql.*;

public class java_13832_SessionManager_A03 {
    private Connection conn;
    private Statement stmt;

    public java_13832_SessionManager_A03(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }
}

class Main {
    public static void main(String[] args) {
        try {
            SessionManager sm = new SessionManager("jdbc:mysql://localhost/test", "username", "password");
            ResultSet rs = sm.executeQuery("SELECT * FROM Users");
            
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // do something with the username and password
            }

            sm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}