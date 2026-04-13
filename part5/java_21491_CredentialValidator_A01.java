import java.util.regex.Pattern;

public class java_21491_CredentialValidator_A01 {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&*])");

    public boolean isValidPassword(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        if (validator.isValidPassword("ComplexPassword@123")) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}