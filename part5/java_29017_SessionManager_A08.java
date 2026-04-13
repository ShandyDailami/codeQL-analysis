import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_29017_SessionManager_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection connection;

    public java_29017_SessionManager_A08() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        try {
            sm.getConnection().prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)").execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sm.closeConnection();
    }
}