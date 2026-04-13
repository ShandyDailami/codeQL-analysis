import java.security.Credential;
import java.security.InvalidParameterException;

public class java_31056_CredentialValidator_A01 {

    // A Credential object represents the credentials for a user or an entity.
    // A Credential is a pair of credentials, a user name and a password.
    // The password is not stored, it's merely a string of characters.
    public static class CredentialObject implements Credential {
        private String password;

        public java_31056_CredentialValidator_A01(String password) {
            if (password == null) {
                throw new InvalidParameterException("password cannot be null");
            }
            this.password = password;
        }

        // This method is not used in this example, but the interface requires it.
        public String getPassword() {
            return password;
        }

        // This method is not used in this example, but the interface requires it.
        public String getUsername() {
            return "username";
        }
    }

    // The main entry point for your CredentialValidator.
    // This method is not used in this example, but the interface requires it.
    public static void main(String[] args) {
        CredentialObject credential = new CredentialObject("password");
        checkCredentials(credential, "wrongpassword");
    }

    // This method is used to validate a Credential.
    // It does not do anything with the Credential itself, but only returns false.
    // It can be used to prevent a user from accessing a protected resource.
    public static boolean checkCredentials(Credential credential, String password) {
        return !password.equals(credential.getPassword());
    }
}