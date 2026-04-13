import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_41844_CredentialValidator_A01 {

    private String plainTextPassword;
    private String storedPassword;

    public java_41844_CredentialValidator_A01(String plainTextPassword, String storedPassword) {
        this.plainTextPassword = plainTextPassword;
        this.storedPassword = storedPassword;
    }

    public boolean isPasswordValid() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(plainTextPassword.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < hash.length ; i++){
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }

            String encryptedPassword = sb.toString();

            return encryptedPassword.equals(storedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}