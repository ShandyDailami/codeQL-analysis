import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_35800_CredentialValidator_A03 {

    public static boolean isValidPassword(String password) {
        try {
            // Get the hash of the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Check if the hash is equal to a known good hash
            return hexString.toString().equals("a5a6fe9ddb12e89b14fc44028e0c54b917eff467");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return false;
    }
}