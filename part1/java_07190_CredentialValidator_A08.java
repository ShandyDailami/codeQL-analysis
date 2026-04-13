import java.util.regex.Pattern;

public class java_07190_CredentialValidator_A08 {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{8,}$");

    public boolean isPasswordStrong(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password1 = "Password1@";
        String password2 = "Password@";

        System.out.println(password1 + " is strong: " + validator.isPasswordStrong(password1));
        System.out.println(password2 + " is strong: " + validator.isPasswordStrong(password2));
    }
}