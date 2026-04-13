import java.sql.*;
import java.util.Base64;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_26487_CredentialValidator_A03 implements CredentialValidator {

    private String databaseURL;
    private String username;
    private String password;

    public java_26487_CredentialValidator_A03(String databaseURL, String username, String password) {
        this.databaseURL = databaseURL;
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePassword = (UsernamePasswordCredential) credential;
            return validateUsernamePassword(usernamePassword);
        } else {
            throw new InvalidCredentialException("Unsupported credential type");
        }
    }

    private boolean validateUsernamePassword(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String providedPassword = new String(credential.getPassword());
        String decodedPassword = decodePassword(providedPassword);
        return validatePassword(decodedPassword);
    }

    private String decodePassword(String password) throws InvalidCredentialException {
        return new String(Base64.getDecoder().decode(password));
    }

    private boolean validatePassword(String password) throws InvalidCredentialException {
        try {
            Connection connection = DriverManager.getConnection(databaseURL, username, password);
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
            resultSet.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            throw new InvalidCredentialException("Invalid username or password", e);
        }
    }
}