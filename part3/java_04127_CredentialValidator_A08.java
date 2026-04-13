import java.security.InvalidParameterException;

public class java_04127_CredentialValidator_A08 {

    private static final String HARD_CODED_PASSWORD = "secret";

    public static boolean validate(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password must not be null");
        }
        return password.equals(HARD_CODED_PASSWORD);
    }

    public static void main(String[] args) {
        if (validate("wrongpassword")) {
            System.out.println("Access denied");
        } else {
            System.out.println("Access granted");
        }
    }
}