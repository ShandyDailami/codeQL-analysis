import java.util.Base64;

public class java_30416_CredentialValidator_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean isValid(String username, String password) {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordStr = new String(decodedPassword);

        if (USERNAME.equals(username) && PASSWORD.equals(decodedPasswordStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user";
        String password = "d2ViLWVuYS1zZXJpbmdDb2Rl"; // "user:password" in base64

        boolean isValid = validator.isValid(username, password);

        if (isValid) {
            System.out.println("User is valid.");
        } else {
            System.out.println("User is not valid.");
        }
    }
}