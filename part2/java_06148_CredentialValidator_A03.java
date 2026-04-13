import java.sql.*;
import java.util.Base64;

public class java_06148_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        String securePassword = encodePassword(password);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "' AND password = '" + securePassword + "'");

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}