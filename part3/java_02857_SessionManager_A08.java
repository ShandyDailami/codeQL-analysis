import java.sql.*;

public class java_02857_SessionManager_A08 {
    private static SessionManager instance;
    private Connection connection;
    private String url;
    private String username;
    private String password;

    private java_02857_SessionManager_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        establishConnection();
    }

    public static SessionManager getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new SessionManager(url, username, password);
        }
        return instance;
    }

    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
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
                System.out.println("Closed connection to database");
            } catch (SQLException e) {
                System.out.println("Failed to close connection to database");
                e.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance("jdbc:mysql://localhost:3306/test", "root", "password");
        Connection connection = sessionManager.getConnection();

        // perform integrity check
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id = 1");
            if (resultSet.next()) {
                // integrity check passed
                System.out.println("Integrity check passed");
            } else {
                // integrity check failed
                System.out.println("Integrity check failed");
            }
        } catch (SQLException e) {
            System.out.println("Failed to perform integrity check");
            e.printStackTrace();
        }

        sessionManager.closeConnection();
    }
}