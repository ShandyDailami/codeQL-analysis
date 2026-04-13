import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.usernamePasswordAuthentication;

public class java_00281_CredentialValidator_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public CredentialValidationResult validate(usernamePasswordAuthentication authentication) throws LoginException {
        String username = authentication.getCaller();
        String password = authentication.getCredential();

        // Validate the user credentials against a database
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.prepareStatement("SELECT * FROM USERS WHERE USERNAME = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                return CredentialValidationResult.success();
            }
        } catch (SQLException e) {
            // Handle SQL Exception
            return CredentialValidationResult.failure();
        } finally {
            // Close the resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    // Ignore exception
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // Ignore exception
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Ignore exception
                }
            }
        }

        return CredentialValidationResult.unknown();
    }
}