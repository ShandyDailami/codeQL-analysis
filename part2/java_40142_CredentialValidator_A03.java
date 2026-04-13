import java.util.regex.Pattern;

public class java_40142_CredentialValidator_A03 {
    private static final Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$");

    public boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password1 = "password";
        String password2 = "P@ssw0rd";
        String password3 = "P@ssw0rd1";

        System.out.println(validator.validatePassword(password1));  // should print: false
        System.out.println(validator.validatePassword(password2));  // should print: false
        System.out.println(validator.validatePassword(password3));  // should print: true
    }
}