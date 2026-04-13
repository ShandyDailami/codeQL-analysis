import java.util.Optional;

public class java_02449_CredentialValidator_A08 {
    // Fields
    private String correctUsername;
    private String correctPassword;

    // Constructors
    public java_02449_CredentialValidator_A08(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    // Methods
    public Optional<Boolean> isCredentialValid(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return Optional.of(true);
        } else {
            return Optional.of(false);
        }
    }
}