import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_37125_CredentialValidator_A08 {
    private static final String SALT = "A08_IntegrityFailure";

    public static boolean validateCredentials(String inputPassword, String hashedPassword) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(SALT.getBytes());
        byte[] bytes = md.digest(inputPassword.getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hashedInputPassword = sb.toString();

        return hashedInputPassword.equals(hashedPassword);
    }
}