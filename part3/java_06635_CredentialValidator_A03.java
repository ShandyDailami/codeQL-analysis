import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_06635_CredentialValidator_A03 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public void validate(Credential credential) throws FailedLoginException {
                if (credential instanceof UsernamePasswordCredential) {
                    UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
                    String username = upCredential.getIdentifier();
                    char[] password = upCredential.getPassword();

                    // Here you can put your logic to check if the username and password match some hardcoded values
                    if (username.equals("admin") && new String(password).equals("password")) {
                        System.out.println("Login successful!");
                    } else {
                        throw new FailedLoginException("Invalid username or password");
                    }
                }
            }
        };

        // You can now use this validator to authenticate in your code
        try {
            validator.validate(new UsernamePasswordCredential("admin", "password".toCharArray()));
        } catch (FailedLoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}