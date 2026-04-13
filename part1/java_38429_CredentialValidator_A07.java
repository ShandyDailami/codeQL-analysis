import java.util.Base64;

public class java_38429_CredentialValidator_A07 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public Credential validate(Credential credential) throws CredentialValidationException {
        String inputUsername = credential.getUsername();
        String inputPassword = credential.getPassword();

        if (USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword)) {
            // If the username and password match, create a new Credential object
            // with the username and password.
            credential = new Credential(inputUsername, inputPassword);
        }

        return credential;
    }
}