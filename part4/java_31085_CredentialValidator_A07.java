import java.security.Credential;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.security.spec.InvalidKeySpecException;

public class java_31085_CredentialValidator_A07 {

    public static boolean validate(Credential credential, String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidParameterException {
        if (credential == null || password == null || salt == null) {
            throw new InvalidParameterException("Null parameters not allowed");
        }

        if (credential.getAlgorithm() == null || credential.getAlgorithm().isEmpty()) {
            throw new InvalidParameterException("Null or empty algorithm not allowed");
        }

        if (credential.getCredentialIdentifier() == null || credential.getCredentialIdentifier().isEmpty()) {
            throw new InvalidParameterException("Null or empty credential identifier not allowed");
        }

        byte[] passwordInBytes = password.getBytes();

        byte[] saltInBytes = salt.getBytes();

        byte[] result = credential.validate(passwordInBytes, saltInBytes);

        if (result == null || result.length == 0) {
            return false;
        }

        return true;
    }
}