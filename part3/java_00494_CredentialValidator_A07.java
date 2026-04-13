import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.Validator;
import javax.security.auth.validation.SimpleValidator;
import javax.security.auth.validation.LoginContext;

public class java_00494_CredentialValidator_A07 {

    public static void main(String[] args) {
        Validator validator = new SimpleValidator();
        LoginContext loginContext = new LoginContext("Admin", new UsernamePasswordCredential("admin", "password"));

        try {
            validator.validate(loginContext);
            System.out.println("Login successful");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}