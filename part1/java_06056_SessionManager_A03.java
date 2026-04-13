import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_06056_SessionManager_A03 {
    private String driverClass;
    private String connectionUrl;
    private String userName;
    private String password;

    public java_06056_SessionManager_A03(String driverClass, String connectionUrl, String userName, String password) {
        this.driverClass = driverClass;
        this.connectionUrl = connectionUrl;
        this.userName = userName;
        this.password = password;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "password");

        Connection conn = sessionManager.getConnection();

        // Here is where we do something with the connection...

        sessionManager.closeConnection(conn);
    }
}