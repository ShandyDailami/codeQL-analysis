import java.util.Base64;

public class java_34391_CredentialValidator_A01 {
    private static final String ADMIN_PASSWORD = "YOUR_SECRET_ADMIN_PASSWORD"; // This should never be hardcoded

    public static boolean validate(String password) {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes, 0, decodedBytes.length);

        return decodedPassword.equals(ADMIN_PASSWORD);
    }

    public static void main(String[] args) {
        String testPassword = "QWxwaXBfYXJ0aWZpY3Vyc29mX2tleQ=="; // "admin" in base64
        if (validate(testPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}