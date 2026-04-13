import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.PasswordAuthentication;

public class java_24116_CredentialValidator_A08 {

    public static class CustomValidator implements CredentialValidator {

        public Credential validate(Credential c) throws LoginException {
            String userName = c.getCaller();
            String password = c.getPassword().toString();

            // Here, we're just checking if the username and password match our hard-coded values
            if ("admin".equals(userName) && "password".equals(password)) {
                return new PasswordAuthentication(userName, password.toCharArray());
            }

            return null;
        }
    }

    public static void main(String[] args) {
        javax.security.auth.CredentialValidator validator = new CustomValidator();
        // Use the validator to authenticate
    }
}