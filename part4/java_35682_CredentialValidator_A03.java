import java.util.regex.Pattern;

public class java_35682_CredentialValidator_A03 {
    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    
    public static boolean isValidPassword(String password) {
        return VALID_PASSWORD_PATTERN.matcher(password).matches();
    }
    
    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123"));  // prints: true
        System.out.println(isValidPassword("password"));  // prints: false
    }
}