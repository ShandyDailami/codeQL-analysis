import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23199_SessionManager_A03 {

    // Dependency
    private UserDAO userDAO;

    public java_23199_SessionManager_A03(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void doWorkWithConnections(Connection connection) {
        //...
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager(new UserDAO());
        Connection connection = sessionManager.getConnection();
        sessionManager.doWorkWithConnections(connection);
        sessionManager.closeConnection(connection);
    }
}