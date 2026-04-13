import org.apache.commons.lang3.StringUtils;

public class java_32558_CredentialValidator_A08 {
    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static void main(String[] args) {
        String password = "password123"; // replace with your password
        validatePassword(password);
    }

    public static void validatePassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return;
        }
        if (!StringUtils.contains(password, String.valueOf(Character.toUpperCase(password.charAt(0))))) {
            System.out.println("Password must contain at least one upper case letter.");
            return;
        }
        if (!StringUtils.contains(password, String.valueOf(Character.toLowerCase(password.charAt(0))))) {
            System.out.println("Password must contain at least one lower case letter.");
            return;
        }
        if (!StringUtils.contains(password, String.valueOf(SPECIAL_CHARACTERS.charAt(0)))) {
            System.out.println("Password must contain at least one special character.");
            return;
        }
        if (StringUtils.contains(password, " ")) {
            System.out.println("Password cannot contain spaces.");
            return;
        }
        System.out.println("Password is strong.");
    }
}