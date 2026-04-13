import java.security.credentials.Credential;
import java.security.credentials.PasswordCredential;
import java.security.spec.InvalidParameterSpecException;

public class java_11853_CredentialValidator_A03 implements java.security.authentication.CredentialValidator {

    @Override
    public String getName() {
        return "CustomCredentialValidator";
    }

    @Override
    public String getAlgorithmName() {
        return "none";
    }

    @Override
    public String getCredentialType() {
        return PasswordCredential.class.getName();
    }

    @Override
    public boolean validate(Credential credential) throws InvalidParameterSpecException {
        PasswordCredential passwordCredential = (PasswordCredential) credential;
        String password = new String(passwordCredential.getPassword());

        // The hardcoded pattern we're checking against is "password"
        return password.equals("password");
    }
}