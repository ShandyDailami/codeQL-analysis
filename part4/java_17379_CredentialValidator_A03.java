import java.util.Base64;
import java.security.MessageDigest;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_17379_CredentialValidator_A03 implements CredentialValidator {

    private String password = "password"; // this should be stored securely

    public java_17379_CredentialValidator_A03() {
        // load password from secure storage
        // this is just for demonstration, in a real application, you should not use this line
        password = "password"; 
    }

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        if (credential == null) {
            throw new CredentialException("Null credentials");
        }

        String presentedPassword = new String(credential.getCredentialIdentifier());

        // check password
        if (checkPassword(presentedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkPassword(String presentedPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(presentedPassword.getBytes("default"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPassword = sb.toString();
            return hashedPassword.equals(this.password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}