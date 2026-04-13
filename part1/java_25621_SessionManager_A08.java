import java.sql.*;

public class java_25621_SessionManager_A08 {
    private final String url;
    private final String username;
    private final String password;

    public java_25621_SessionManager_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void startSession() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            // Start the session
            connection.createStatement().execute("START TRANSACTION");

            // Perform some integrity sensitive operations...

            // If no exceptions are thrown, commit the transaction
            connection.createStatement().execute("COMMIT");

            connection.close();
        } catch (SQLException e) {
            // Handle the integrity failure
            System.out.println("Integrity failure detected: " + e.getMessage());
        }
    }
}