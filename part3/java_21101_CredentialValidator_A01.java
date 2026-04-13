import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_21101_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check for at least one upper case, one lower case and one digit
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*/d)[a-zA-Z0-9].+$");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String password = "Abc@123";
        boolean isValid = validatePassword(password);
        if (isValid) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}