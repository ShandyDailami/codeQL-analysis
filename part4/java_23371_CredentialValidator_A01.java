import java.util.Optional;
import java.util.function.Function;

public class java_23371_CredentialValidator_A01 {
    private Function<String, Optional<String>> getPassword;

    public java_23371_CredentialValidator_A01(Function<String, Optional<String>> getPassword) {
        this.getPassword = getPassword;
    }

    public boolean validateCredentials(String username, String password) {
        Optional<String> optionalPassword = getPassword.apply(username);

        if (!optionalPassword.isPresent()) {
            System.out.println("No password found for user: " + username);
            return false;
        }

        String storedPassword = optionalPassword.get();

        if (storedPassword.equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}