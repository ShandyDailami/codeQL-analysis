import java.sql.*;
import java.util.prefs.*;

public class java_07131_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn;
    private Statement stmt;
    private Preferences prefs;

    public java_07131_JDBCQueryHandler_A07() {
        try {
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            this.stmt = conn.createStatement();
            this.prefs = UserPreferences.forUserDirectory(User.current());
        } catch (SQLException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuery(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSecurityPref(String key, String value) {
        prefs.put(key, value);
    }

    public String getSecurityPref(String key) {
        return prefs.get(key, null);
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        // setting a security preference
        handler.setSecurityPref("auth_failure", "true");

        // retrieving a security preference
        String authFailure = handler.getSecurityPref("auth_failure");
        System.out.println("Auth Failure Status: " + authFailure);

        // running a query
        handler.executeQuery("SELECT username FROM users WHERE username = '" + handler.getSecurityPref("username") + "'");

        // update query
        handler.updateQuery("UPDATE users SET password = 'new_password' WHERE username = '" + handler.getSecurityPref("username") + "'");
    }
}