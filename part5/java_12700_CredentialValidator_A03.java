import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.UnknownAccountException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

public class java_12700_CredentialValidator_A03 implements CredentialValidator {
    // Hash map for storing users and their passwords
    private final Map<String, String> userDatabase = new HashMap<>();

    // Constructor to initialize the user database
    public java_12700_CredentialValidator_A03() {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        // Add more users if needed
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler)
            throws LoginException, UnknownAccountException {
        return validate(callbackHandler);
    }

    @Override
    public boolean validate(CallbackHandler callbackHandler)
            throws LoginException, UnknownAccountException {
        Callback callback = callbackHandler.getCallback();

        // Get the username and password from the callback
        String username = callback.getUsername();
        String password = new String(callback.getPassword(), StandardCharsets.UTF_8);

        // Validate the username and password against the database
        if (userDatabase.containsKey(username)
                && userDatabase.get(username).equals(hashPassword(password))) {
            return true;
        }

        throw new UnknownAccountException();
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}