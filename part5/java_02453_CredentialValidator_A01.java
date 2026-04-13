import java.security.InvalidParameterException;
import java.util.Base64;

public class java_02453_CredentialValidator_A01 implements CredentialValidator {
    private static final String USER_ALIAS = "User";
    private static final String PASSWORD_ALIAS = "Password";

    @Override
    public boolean validate(InputStream credentialState) throws InvalidParameterException {
        // Decode the state
        byte[] decodedCredentials = Base64.getDecoder().decode(credentialState);

        // Split the decoded credentials into username and password
        String[] decodedCredentialsArray = new String(decodedCredentials, "UTF-8").split(":");

        if (decodedCredentialsArray.length != 2) {
            throw new InvalidParameterException("Invalid credentials format");
        }

        String username = decodedCredentialsArray[0];
        String password = decodedCredentialsArray[1];

        // Add your own security-sensitive operations here
        // This is a placeholder, replace it with actual security-sensitive operations
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }

        return false;
    }

    @Override
    public String getUserName(InputStream credentialState) throws InvalidParameterException {
        return USER_ALIAS;
    }

    @Override
    public String getPassword(InputStream credentialState) throws InvalidParameterException {
        return PASSWORD_ALIAS;
    }
}