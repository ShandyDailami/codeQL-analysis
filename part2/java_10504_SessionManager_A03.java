import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_10504_SessionManager_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_10504_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void storeData(String username, String data) {
        try {
            String query = "INSERT INTO users (username, data) VALUES (?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, data);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String retrieveData(String username) {
        try {
            String query = "SELECT data FROM users WHERE username = ?";
            PreparedStatement statement = this.connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("data");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.storeData("user1", "My data");
        String data = sessionManager.retrieveData("user1");
        System.out.println("Retrieved data: " + data);
    }
}