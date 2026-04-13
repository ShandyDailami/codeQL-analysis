import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_15263_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public Credential validate(Credential c) throws LoginException {
        // If the provided credential is not of UsernamePasswordCredential type, return null.
        if (!(c instanceof UsernamePasswordCredential))
            return null;

        // Cast UsernamePasswordCredential to UsernamePassword and get credentials.
        UsernamePasswordCredential upc = (UsernamePasswordCredential) c;
        String user = upc.getCaller();
        char[] password = upc.getPassword();

        // Calculate the MD5 hash of the password.
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(password);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String encryptedPassword = sb.toString();

            // If the user and encrypted password match, return a Credential.
            if (USERNAME.equals(user) && encryptedPassword.equals(PASSWORD)) {
                return c;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}