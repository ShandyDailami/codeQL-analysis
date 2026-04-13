import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_38252_CredentialValidator_A03 {

    private String password;

    public java_38252_CredentialValidator_A03(String password) {
        this.password = password;
    }

    public boolean validate(String enteredPassword) {
        if (null == enteredPassword) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(this.password.getBytes());
            byte[] enteredPasswordBytes = enteredPassword.getBytes();

            return MessageDigest.isEqual(hashedPassword, md.digest(enteredPasswordBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        String password = new BigInteger(160, sr).toString(32);
        CredentialValidator cv = new CredentialValidator(password);

        System.out.println("Password: " + password);
        System.out.println("Authentication result: " + cv.validate(password));
    }
}