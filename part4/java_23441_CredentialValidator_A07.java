import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.LoginContext;
import javax.security.auth.validation.ValidationResult;

public class java_23441_CredentialValidator_A07 {

    public boolean validate(Credential credential) throws LoginException {
        ValidationResult result = null;

        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;

            String username = usernamePasswordCredential.getIdentifier();
            String password = String.valueOf(usernamePasswordCredential.getPassword());

            // In a real use case, you would likely call a method to authenticate the user.
            // Here, we'll just check if the username and password match the hardcoded values.
            if (username.equals("admin") && password.equals("password")) {
                result = ValidationResult.success();
            } else {
                result = ValidationResult.failed();
            }
        }

        return result != null && result.getStatus() == ValidationResult.Status.SUCCESS;
    }

    public static void main(String[] args) throws LoginException {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        Credential credential = new UsernamePasswordCredential("admin", "password".toCharArray());

        boolean isValid = validator.validate(credential);

        System.out.println("Is valid: " + isValid);
    }
}