import java.util.Base64;
import java.util.Optional;

public class java_03268_CredentialValidator_A03 implements CredentialValidator {
    @Override
    public Optional<String> validate(String userName, String password) {
        // This is a placeholder for a real password check, 
        // in a real scenario, you would compare the password with a hash of the password
        if (userName.equals("admin") && password.equals("password")) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }

    @Override
    public Optional<String> validate(String userName, byte[] password) {
        // This is a placeholder for a real password check, 
        // in a real scenario, you would compare the password with a hash of the password
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        if (userName.equals("admin") && decodedPassword.equals("password")) {
            return Optional.empty();
        } else {
            return Optional.of("Invalid username or password");
        }
    }
}