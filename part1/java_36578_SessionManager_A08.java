import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_36578_SessionManager_A08 {

    private Connection connection;

    public void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void startSession() {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void commitSession() {
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void rollbackSession() {
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.openConnection();
        sm.startSession();
        sm.commitSession();
        sm.closeConnection();
    }
}