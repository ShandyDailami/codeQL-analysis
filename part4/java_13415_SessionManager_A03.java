import java.sql.*;

public class java_13415_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_13415_SessionManager_A03() {
        try {
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "username", "password");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void endSession(String message) {
        try {
            if (message.equals("success")) {
                connection.commit();
            } else {
                connection.rollback();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void performOperation(String operation) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(operation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}