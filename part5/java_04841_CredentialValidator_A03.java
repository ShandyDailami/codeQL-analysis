import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_04841_CredentialValidator_A03 {

    private String securePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public boolean validate(String passwordAttempt) {
        return securePassword(passwordAttempt).equals(securePassword(passwordAttempt));
    }
}