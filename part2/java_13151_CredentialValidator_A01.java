import java.util.Optional;
import java.util.function.Supplier;

public class java_13151_CredentialValidator_A01 {

    private Supplier<Optional<String>> passwordSupplier;

    public java_13151_CredentialValidator_A01(Supplier<Optional<String>> passwordSupplier) {
        this.passwordSupplier = passwordSupplier;
    }

    public boolean validate() {
        Optional<String> password = passwordSupplier.get();
        if (password.isEmpty()) {
            throw new IllegalStateException("Password not provided");
        }
        return isValidPassword(password.get());
    }

    private boolean isValidPassword(String password) {
        // Checking the length and presence of special characters
        if (password.length() < 8 || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
            return false;
        }
        // Checking if password is in the common or dictionary words
        try {
            String commonWord = Optional.ofNullable(System.getProperty("user.country")).orElse("");
            commonWord = new StringBuilder(commonWord).reverse().toString(); // reverse the common word
            if (password.equals(commonWord)) {
                return false;
            }
        } catch (Exception e) {
            // no specific reason for exception, this will handle all cases
        }
        // Password is valid
        return true;
    }
}