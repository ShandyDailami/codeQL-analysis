import java.sql.*;
import java.util.Properties;

public class java_38432_JDBCQueryHandler_A07 {
    private Connection conn = null;
    private Statement stmt = null;

    private final String url;
    private final String user;
    private final String password;

    public java_38432_JDBCQueryHandler_A07(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void connect() {
        try {
            Properties props = new Properties();
            props.setProperty("user", this.user);
            props.setProperty("password", this.password);

            this.conn = DriverManager.getConnection(this.url, props);
            this.stmt = this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (this.stmt != null)
                this.stmt.close();

            if (this.conn != null)
                this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return this.stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            return this.stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}