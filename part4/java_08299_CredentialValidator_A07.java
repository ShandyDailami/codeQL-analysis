import java.security.InvalidParameterException;

public class java_08299_CredentialValidator_A07 {

    private static final String PREDEFINED_PASSWORD = "password";

    public static boolean isValid(String password) {
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }
        return password.equals(PREDEFINED_PASSWORD);
    }

    public static void main(String[] args) {
        String password = "wrongPassword";
        if (isValid(password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}