import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;
import javax.sql.rowset.CredentialsRevokedException;

public class java_33125_CredentialValidator_A07 implements CredentialValidator {

    private String url;
    private String username;
    private String password;

    public java_33125_CredentialValidator_A07(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public CredentialValidationResult validate(Subject subject, Credential credential) {
        if (credential == null) {
            return CredentialValidationResult.success();
        }

        if ("Basic".equals(credential.getClass().getName())) {
            return validateBasicCredential((BasicCredential) credential);
        }

        return CredentialValidationResult.failure();
    }

    private CredentialValidationResult validateBasicCredential(BasicCredential credential) {
        String base64Credentials = credential.getCredentialIdentifier();
        String credentialsStr = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        String[] credentialsArray = credentialsStr.split(":");

        if (credentialsArray.length != 2) {
            return CredentialValidationResult.failure();
        }

        String username = credentialsArray[0];
        String password = credentialsArray[1];

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT 1 FROM USERS WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                return CredentialValidationResult.success();
            }
        } catch (SQLException e) {
            return CredentialValidationResult.failure();
        }

        return CredentialValidationResult.failure();
    }

    public CallbackHandler getCallbackHandler() {
        return new CallbackHandler() {
            public CredentialValidationResult handle(Callback callback[]) throws UnsupportedCallbackException {
                return null;
            }
        };
    }
}