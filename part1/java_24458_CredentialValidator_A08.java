import java.security.InvalidParameterException;

public class java_24458_CredentialValidator_A08 {

    public static boolean validate(UsernamePasswordCredentials credentials) {
        if (credentials == null) {
            throw new InvalidParameterException("Credentials cannot be null");
        }

        if (credentials.getUsername() == null || credentials.getUsername().isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }

        if (credentials.getPassword() == null || credentials.getPassword().isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        // Here you can use your own logic to validate the credentials. For example, you can compare the
        // credentials to a database or another external source of credentials. If the credentials are
        // valid, return true. Otherwise, return false.

        // For this example, let's just return true for simplicity
        return true;
    }

}