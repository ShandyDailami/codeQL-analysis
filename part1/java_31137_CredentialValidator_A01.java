import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31137_CredentialValidator_A01 {

    private String passwordToCheck;

    public java_31137_CredentialValidator_A01(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }

    public boolean isValidPassword(String userPassword, String salt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(this.passwordToCheck.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedPassword = sb.toString();
        return hashedPassword.equals(userPassword);
    }

}