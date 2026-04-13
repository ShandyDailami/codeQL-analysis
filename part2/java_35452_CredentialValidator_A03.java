import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35452_CredentialValidator_A03 {

    public static void main(String[] args) {
        try {
            String password = "test";
            String hashedPassword = hashPassword(password);

            System.out.println("Hashed password: " + hashedPassword);

            if (validatePassword(hashedPassword, password)) {
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is invalid.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return bytesToHex(hash);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static boolean validatePassword(String hashedPassword, String password) throws NoSuchAlgorithmException {
        return hashedPassword.equals(hashPassword(password));
    }
}