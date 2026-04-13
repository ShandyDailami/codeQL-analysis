import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

public class java_00503_CredentialValidator_A01 implements CredentialValidator {

    private final String password;

    public java_00503_CredentialValidator_A01(String password) {
        this.password = password;
    }

    @Override
    public boolean validate(Principal p) {
        String password = getPassword(p);
        return password != null && password.equals(hashPassword(password));
    }

    private String getPassword(Principal p) {
        // This method is left empty. It should return the password for the given principal.
        // In a real application, this method would retrieve the password from the database or some other secure storage.
        return null;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}