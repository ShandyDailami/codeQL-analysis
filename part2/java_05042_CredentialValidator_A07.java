import java.util.Base64;
import java.util.HashMap;
import java.security.Principal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.security.Credential;
import java.security.AuthFailure;
import java.security.AuthenticationException;

public class java_05042_CredentialValidator_A07 implements CredentialValidator {

    // The passwords that are being validated.
    private HashMap<String, String> credentialsMap;

    // Default constructor.
    public java_05042_CredentialValidator_A07() {
        credentialsMap = new HashMap<String, String>();
    }

    // Add a credential to the validator.
    public void addCredential(String user, String password) {
        try {
            // Hash the password.
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] thedigest = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String encryptedPassword = sb.toString();
            credentialsMap.put(user, encryptedPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Get the password for the given user.
    public String getPassword(String user) {
        return credentialsMap.get(user);
    }

    // The validate method.
    public boolean validate(Credential credential) throws AuthenticationException {
        String password = null;
        try {
            // Get the user from the credential.
            Principal user = credential.getPrincipal();
            password = getPassword(user.getName());
        } catch (NullPointerException e) {
            throw new AuthFailureException("Null credentials");
        } catch (AuthenticationException e) {
            throw new AuthFailureException("Could not validate user credentials");
        }

        // Compare the hashed passwords.
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] thedigest = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String encryptedPassword = sb.toString();

            if (encryptedPassword.equals(getPassword(user.getName()))) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        throw new AuthenticationException("Password incorrect");
    }
}