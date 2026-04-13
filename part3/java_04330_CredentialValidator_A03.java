import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_04330_CredentialValidator_A03 {
    private static final Pattern SPECIAL_CHARACTERS_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isValidPassword(String password) {
        Matcher matcher = SPECIAL_CHARACTERS_PATTERN.matcher(password);
        if (matcher.find()) {
            return false;
        }

        // Add more complex password rules here

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String password = "password@123"; // Change this to test the validator
        if (validator.isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}