import java.util.regex.Pattern;

public class java_10589_CredentialValidator_A03 {

    // Check if the password contains at least one uppercase letter, one lowercase letter, one digit, and one special character
    public static boolean isPasswordStrong(String password) {
        return password.length() >= 8 && 
               Pattern.matches(".*[A-Z]*.*", password) && 
               Pattern.matches(".*[a-z]*.*", password) && 
               Pattern.matches(".*[0-9]*.*", password) && 
               Pattern.matches(".*[^a-zA-Z0-9]*.*", password);
    }

    public static void main(String[] args) {
        // Test the function
        System.out.println(isPasswordStrong("password1234")); // Output: true
        System.out.println(isPasswordStrong("password")); // Output: false
    }
}