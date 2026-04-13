import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.PasswordCredential;
import javax.security.auth.Subject;

public class java_09606_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if (credential instanceof PasswordCredential) {
            PasswordCredential pcCredential = (PasswordCredential) credential;
            String userName = pcCredential.getCaller();
            String password = new String(pcCredential.getPassword());

            // In a real-world application, you would typically check the user against a database.
            // This is just a simple check for the purpose of this example.
            if ("test".equals(userName) && "test".equals(password)) {
                return CredentialValidationResult.success();
            } else {
                return CredentialValidationResult.failed();
            }
        } else {
            return CredentialValidationResult.failed();
        }
    }

    @Override
    public boolean validate(Subject subject, Credential credential) {
        return validate(credential).getResult().equals(CredentialValidationResult.SUCCESS);
    }
}