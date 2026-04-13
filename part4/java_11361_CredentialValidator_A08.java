import java.util.regex.Pattern;

public class java_11361_CredentialValidator_A08 {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}$");

    public boolean isUsernameValid(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isPasswordValid(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean isCredentialValid(String username, String password) {
        return isUsernameValid(username) && isPasswordValid(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.isCredentialValid("admin", "Password@99"));
        System.out.println(validator.isCredentialValid("admin", "password"));
        System.out.println(validator.isCredentialValid("admin", "Password@"));
        System.out.println(validator.isCredentialValid("admin9", "Password@99"));
    }
}