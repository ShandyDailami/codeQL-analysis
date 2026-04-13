import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_31069_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public java_31069_SessionManager_A01() {
        this.connect();
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to database successfully.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error occurred while closing the connection.");
                e.printStackTrace();
            }
        }
    }
}