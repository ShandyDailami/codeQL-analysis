import java.util.regex.Pattern;

public class java_17601_CredentialValidator_A08 {

    private static final Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public boolean isPasswordStrong(String password) {
        return pattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        System.out.println(validator.isPasswordStrong("Password@123")); // True
        System.out.println(validator.isPasswordStrong("password@123")); // False
   
    }
}