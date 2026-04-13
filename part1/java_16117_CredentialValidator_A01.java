import java.util.regex.Pattern;

public class java_16117_CredentialValidator_A01 {
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public static boolean validate(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        System.out.println(validate("Password@123")); // true
        System.out.println(validate("password@123")); // false
   .
.
.
.
    }
}