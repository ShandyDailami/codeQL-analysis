import java.util.Base64;
import java.util.Optional;

public class java_10803_CredentialValidator_A07 {

    public Optional<String> validateCredential(String userName, String password) {
        // This is a very simple example and in real application, you should use secure hash algorithms and real database.
        String validPassword = "d0ur3d_p455w0rd";

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String encodedValidPassword = Base64.getEncoder().encodeToString(validPassword.getBytes());

        if (encodedPassword.equals(encodedValidPassword)) {
            return Optional.empty();
        } else {
            return Optional.of("Wrong password");
        }
    }
}