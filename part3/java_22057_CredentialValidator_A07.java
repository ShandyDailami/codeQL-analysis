import java.util.Base64;

public class java_22057_CredentialValidator_A07 {

    private static final String HARD_CODED_PASSWORD = "d06f1c1874b6ea41f4a5a6e5e0999ec1"; // Base64 encoding of "password"

    public static boolean validate(String password) {
        return password != null && password.equals(new String(Base64.getDecoder().decode(HARD_CODED_PASSWORD)));
    }

    public static void main(String[] args) {
        System.out.println(validate("password")); // This should print true
        System.out.println(validate("wrongPassword")); // This should print false
    }
}