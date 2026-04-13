import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_13965_CredentialValidator_A08 {

    public boolean validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential upCredential = (UsernamePasswordCredential) credential;
            String password = upCredential.getPasswordAsString();
            return isPasswordStrong(password);
        } else {
            throw new IllegalArgumentException("Unsupported credential type: " + credential.getClass().getName());
        }
    }

    private boolean isPasswordStrong(String password) {
        // Implement your own password strength check logic here
        // This is a simple check that only checks for length
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        UsernamePasswordCredential credential = new UsernamePasswordCredential("user", "strongpassword");
        boolean isValid = validator.validate(credential);

        System.out.println("Is password strong? " + isValid);
    }
}