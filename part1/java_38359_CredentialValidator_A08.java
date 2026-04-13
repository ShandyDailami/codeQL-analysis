import java.security.InvalidParameterException;
import java.util.Base64;

public class java_38359_CredentialValidator_A08 {

    public interface CredentialValidator {
        boolean validate(String user, String password);
    }

    private CredentialValidator credentialValidator;

    public java_38359_CredentialValidator_A08(CredentialValidator credentialValidator) {
        if (credentialValidator == null) {
            throw new InvalidParameterException("CredentialValidator cannot be null");
        }
        this.credentialValidator = credentialValidator;
    }

    public String validateAndDecodeCredential(String credential) {
        String userAndPassword;
        try {
            userAndPassword = new String(Base64.getDecoder().decode(credential), "UTF-8");
        } catch (Exception e) {
            throw new InvalidParameterException("Invalid Base64 credential");
        }

        String[] credentials = userAndPassword.split(":");
        if (credentials.length != 2 || credentials[0] == null || credentials[1] == null) {
            throw new InvalidParameterException("Invalid format of credential, expected format is USERNAME:PASSWORD");
        }

        String user = credentials[0];
        String password = credentials[1];

        if (!credentialValidator.validate(user, password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return user;
    }
}