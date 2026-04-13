import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_37514_CredentialValidator_A07 {
    private String url;
    private String username;
    private String password;

    public java_37514_CredentialValidator_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public boolean validateCredentials() {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT 1 FROM USERS WHERE USERNAME='" + username + "' AND PASSWORD='" + password + "'");
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("jdbc:mysql://localhost:3306/test", "username", "password");
        boolean isValid = validator.validateCredentials();
        System.out.println("Is valid? " + isValid);
    }
}