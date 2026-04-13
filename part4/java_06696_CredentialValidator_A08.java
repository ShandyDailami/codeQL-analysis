import java.security.credential.*;

public class java_06696_CredentialValidator_A08 implements CredentialValidator {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            return usernamePasswordCredential.getUsername().equals(USERNAME)
                    && usernamePasswordCredential.getPassword().equals(PASSWORD);
        }
        return false;
    }
}