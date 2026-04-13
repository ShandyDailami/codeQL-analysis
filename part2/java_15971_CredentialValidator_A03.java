import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_15971_CredentialValidator_A03 {
    public static boolean validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential userCredential = (UsernamePasswordCredential) credential;
            String password = userCredential.getPassword();
            // Password must contain at least one uppercase letter, one lowercase letter, one special character, and one digit
            if (password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UsernamePasswordCredential credential = new UsernamePasswordCredential("username", "password");
        System.out.println(validate(credential)); // Outputs: true or false based on the password's strength
    }
}