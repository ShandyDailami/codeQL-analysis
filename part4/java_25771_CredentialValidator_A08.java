import java.security.InvalidParameterException;

public class java_25771_CredentialValidator_A08 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_25771_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        if (expectedUsername == null || expectedUsername.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty");
        }
        if (expectedPassword == null || expectedPassword.isEmpty()) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public String getId() {
        return "MyCredentialValidator";
    }

    @Override
    public PasswordCredential[] validate(PasswordCredential[] passwordCredentials) {
        if (passwordCredentials == null || passwordCredentials.length == 0) {
            return new PasswordCredential[0];
        }

        PasswordCredential[] validCredentials = new PasswordCredential[passwordCredentials.length];
        for (int i = 0; i < passwordCredentials.length; i++) {
            PasswordCredential credential = passwordCredentials[i];
            if (credential.getUsername().equals(expectedUsername) &&
                    credential.getPassword().equals(expectedPassword)) {
                validCredentials[i] = credential;
            }
        }
        return validCredentials;
    }
}