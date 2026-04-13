import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_37815_CredentialValidator_A08 {

    public CredentialValidatorResult validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getIdentifier();
            char[] password = usernamePasswordCredential.getPassword();

            // This is a placeholder. In real scenario, you'd want to connect to a database
            // and check the user's credentials here. For simplicity, we'll just return true
            // for all valid credentials.
            if (username.equals("admin") && passwordToString(password)
                    .equals("password")) {
                return new CredentialValidatorResult.Success();
            } else {
                return new CredentialValidatorResult.Failed(new UnavailableException("Invalid Credentials"));
            }
        } else {
            return new CredentialValidatorResult.Failed(new UnavailableException("Invalid Credentials Type"));
        }
    }

    private String passwordToString(char[] password) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : password) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}