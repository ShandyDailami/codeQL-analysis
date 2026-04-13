import java.util.Base64;
import java.util.Optional;

public class java_08376_CredentialValidator_A03 {

    // This is a simple example, real world usage should handle encryption and decryption.
    private static Optional<String> username = Optional.of("user");
    private static Optional<String> password = Optional.of("password");

    public static Optional<String> validate(String user, String password) {
        if (user == null || password == null) {
            return Optional.empty();
        }

        if (!user.equals(username.get()) || !this.decrypt(password).equals(CredentialValidator.this.decrypt(password))) {
            return Optional.empty();
        }

        return Optional.of("User Authenticated");
    }

    // This is a helper method to decrypt the password
    private String decrypt(String password) {
        return new String(Base64.getDecoder().decode(password));
    }

    public static void main(String[] args) {
        Optional<String> result = CredentialValidator.validate("user", "password");

        if(result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Credentials are incorrect");
        }
    }
}