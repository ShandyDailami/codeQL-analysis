import javax.security.auth.Credential;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_39984_CredentialValidator_A08 {

    public static void main(String[] args) {
        CredentialValidationResult result = validate("admin", "password");
        if(result.getState() == CredentialValidationResult.STATE_VALID) {
            System.out.println("User is authenticated successfully!");
        } else {
            System.out.println("Failed to authenticate user. Authentication failed with following messages: " + result.getFailureMessages());
        }
    }

    public static CredentialValidationResult validate(String username, String password) {
        Credential c = new Credential() {
            public String getName() {
                return username;
            }

            public String getPassword() {
                return password;
            }
        };

        PasswordAuthentication pa = new PasswordAuthentication(c, null);

        return pa.validate();
    }
}