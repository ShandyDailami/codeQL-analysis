import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.message.MessageException;

public class java_41549_CredentialValidator_A01 {
    public CredentialValidationResult validate(Credential credential) {
        String username = credential.getCaller();
        char[] password = credential.getPassword();

        // Here you should implement your own logic to validate the credentials
        // For simplicity, we'll just check if the username is "admin" and the password is "password"
        if ("admin".equals(username) && "password".equals(new String(password))) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed();
        }
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator();
        Credential credential = new UsernamePasswordCredential("admin", "password".toCharArray());

        CredentialValidationResult result = validator.validate(credential);

        if (result.getState().equals(CredentialValidationResult.State.SUCCESS)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}