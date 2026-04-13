import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34288_SessionManager_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            if (connection.isClosed()) {
                System.out.println("Connection is closed");
            } else {
                System.out.println("Connection is not closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Trying to open a session with incorrect password
        try (Connection connection = DriverManager.getConnection(url, "wrong_username", password)) {
            System.out.println("Failed to open session with incorrect password");
        } catch (SQLException e) {
            System.out.println("Successfully tried to open session with incorrect password");
        }

        // Trying to open a session with incorrect username
        try (Connection connection = DriverManager.getConnection(url, "incorrect_username", password)) {
            System.out.println("Failed to open session with incorrect username");
        } catch (SQLException e) {
            System.out.println("Successfully tried to open session with incorrect username");
        }

        // Trying to open a session with correct username and password
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Successfully opened session");
        } catch (SQLException e) {
            System.out.println("Failed to open session");
        }
    }
}