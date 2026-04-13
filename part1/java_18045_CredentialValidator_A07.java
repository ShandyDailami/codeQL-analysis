import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_18045_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String validate(String arg0) throws LoginException {
        String decodedString = new String(Base64.getDecoder().decode(arg0));
        if(isValid(decodedString)) {
            return arg0;
        }
        throw new LoginException("Invalid credentials");
    }

    private boolean isValid(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(str.getBytes("UTF-8"));
            String encodedString = Base64.getEncoder().encodeToString(hash);
            return str.equals(encodedString);
        } catch (NoSuchAlgorithmException | java.lang.StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return false;
    }
}