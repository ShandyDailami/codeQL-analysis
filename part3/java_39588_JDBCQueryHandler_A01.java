import java.sql.*;
import java.util.Properties;

public class java_39588_JDBCQueryHandler_A01 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    private Connection conn = null;
    private Statement stmt = null;

    public void connect() {
        Properties props = new Properties();
        props.setProperty("user","username");
        props.setProperty("password","password");
        props.setProperty("useSSL","false");
        props.setProperty("verifyServerCertificate","false");
        props.setProperty("requireSSL","false");

        try {
            conn = DriverManager.getConnection(url,props);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (stmt != null)
                stmt.close();

            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}