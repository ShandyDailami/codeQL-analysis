import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38114_SessionManager_A03 {

    // Injecting the database credentials
    private static final String USER = "dbUser";
    private static final String PASSWORD = "dbPassword";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";

    // A method to get the database connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }

    // A method to close the database connection
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Connection connection = sessionManager.getConnection();

        // TODO: Security-sensitive operations here

        sessionManager.closeConnection(connection);
    }
}