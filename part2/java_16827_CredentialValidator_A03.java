import java.security.Security;
import java.security.cert.CertificateException;

public class java_16827_CredentialValidator_A03 {

    public static boolean validate(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password contains any whitespace
        if (password.contains(" ")) {
            return false;
        }

        // Check if password length is greater than 8
        if (password.length() <= 8) {
            return false;
        }

        // Check if password contains any common passwords
        String[] commonPasswords = {"password", "admin", "qwerty", "123456", "654321"};
        for (String commonPassword : commonPasswords) {
            if (password.equals(commonPassword)) {
                return false;
            }
        }

        // Check if password contains any uppercase letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check if password contains any digit
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Check if password contains any special character
        if (!password.matches(".*[!@#$%^&*()_+{}\\|:<>?].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException,
            InvalidKeySpecException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        System.out.println(validate("YourPassword@123")); // Should print true
        System.out.println(validate("password")); // Should print false
    }
}