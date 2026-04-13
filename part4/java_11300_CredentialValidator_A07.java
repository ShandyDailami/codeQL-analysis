import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_11300_CredentialValidator_A07 {
    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");
    
    public static boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        System.out.println(isValidPassword("A07_AuthFailure")); // Output: false
        System.out.println(isValidPassword("Password@123")); // Output: true
    }
}