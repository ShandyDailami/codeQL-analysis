import java.util.Base64;
import java.util.Optional;

public class java_08974_CredentialValidator_A08 {

    public Optional<String> validateCredential(String userName, String password) {
        // This is a simple example. In real-world applications, you would want to hash and salt passwords and compare hashes, not plain text passwords.
        // Also, in a more secure way, you would want to check against a database, not just a hardcoded string.
        if ("test".equals(userName) && "password".equals(password)) {
            return Optional.of("Success");
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> validateCredentialWithBase64(String userName, String password) {
        // Decoding the password first before comparison.
        Optional.of(new String(Base64.getDecoder().decode(password))).flatMap(pass -> validateCredential(userName, pass));
        return Optional.empty();
    }
}