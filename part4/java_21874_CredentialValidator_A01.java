import java.security.Provider;
import java.security.Security;

public class java_21874_CredentialValidator_A01 {
    // A01_BrokenAccessControl: Use standard libraries only.

    // Solution 1: Use a custom security provider
    public static class CustomProvider extends Security.Provider {
        @Override
        public String findPasswordValidation(String password) {
            // Simulate password validation
            if (password != null && !password.isEmpty()) {
                return "Password is valid";
            } else {
                return "Password is not valid";
            }
        }
    }

    public static void main(String[] args) {
        // Initialize the custom provider
        Provider provider = new CustomProvider();
        Security.addProvider(provider);

        // Use the custom provider
        String password = "securePassword";
        String result = Security.getPasswordValidator().validate(password);
        System.out.println(result);
    }
}