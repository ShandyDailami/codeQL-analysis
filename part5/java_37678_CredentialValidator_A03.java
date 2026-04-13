import java.util.regex.Pattern;

public class java_37678_CredentialValidator_A03 {

    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");

    public boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password1 = "Abcd1234";
        String password2 = "password";

        System.out.println(password1 + " is strong: " + validator.validatePassword(password1));
        System.out.println(password2 + " is strong: " + validator.validatePassword(password2));
    }
}