import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31296_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_31296_SessionManager_A07() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (!isConnectionSecure()) {
            throw new SecurityFailureException("Attempt to access database from non-secure connection");
        }
        return connection;
    }

    private boolean isConnectionSecure() {
        String remoteHost = connection.getMetaData().getURL().getHost();
        return remoteHost.equals("localhost");
    }
}