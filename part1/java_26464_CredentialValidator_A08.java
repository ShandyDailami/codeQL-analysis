import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_26464_CredentialValidator_A08 {

    public CredentialValidatorResult validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        if ("correctpassword".equals(password)) {
            return new CredentialValidatorResult("Success", null, null);
        } else {
            return new CredentialValidatorResult("Incorrect Password", null, null);
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        CredentialValidatorResult result = validator.validate(new UsernamePasswordCredential("testuser", "correctpassword"));
        System.out.println(result.getMessage());
    }
}