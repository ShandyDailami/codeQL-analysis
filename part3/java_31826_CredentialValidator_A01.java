import java.util.Base64;
import java.util.Base64.Decoder;

public class java_31826_CredentialValidator_A01 {
    private static final String BASE64_SECRET = "ZGVhcm5tZ25lX2tleQ=="; // "password" decoded from Base64

    public static boolean validate(String username, String password) {
        Decoder decoder = Base64.getDecoder();
        String decodedSecret = new String(decoder.decode(BASE64_SECRET));

        // Simulate a password validation operation
        return password.equals(decodedSecret);
    }

    public static void main(String[] args) {
        String username = "user";
        String password = "password";

        if (validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}