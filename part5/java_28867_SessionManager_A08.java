import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class java_28867_SessionManager_A08 {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private DataSource dataSource;

    public java_28867_SessionManager_A08() {
        Properties properties = new Properties();
        properties.setProperty("driverClassName", DRIVER_CLASS);
        properties.setProperty("url", DB_URL);
        properties.setProperty("username", USERNAME);
        properties.setProperty("password", PASSWORD);
        dataSource = new BasicDataSource();
        dataSource.setProperties(properties);
    }

    public void startSession() {
        try {
            dataSource.getConnection().prepareStatement("begin transaction").execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commitSession() {
        try {
            dataSource.getConnection().prepareStatement("commit").execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void endSession(boolean rollback) {
        try {
            if (rollback) {
                dataSource.getConnection().prepareStatement("rollback").execute();
            } else {
                dataSource.getConnection().prepareStatement("commit").execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        try {
            dataSource.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySessionManager sessionManager = new MySessionManager();
        sessionManager.startSession();
        // perform security sensitive operations here
        sessionManager.commitSession();
        sessionManager.endSession(false);
        sessionManager.closeSession();
    }
}