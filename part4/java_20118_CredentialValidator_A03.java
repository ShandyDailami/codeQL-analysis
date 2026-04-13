import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_20118_CredentialValidator_A03 {

    private Map<String, String> credentialMap;
    private Encoder encoder = Base64.getEncoder();
    private Decoder decoder = Base64.getDecoder();

    public java_20118_CredentialValidator_A03() {
        this.credentialMap = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentialMap.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        String encodedPassword = encoder.encodeToString(password.getBytes());
        if (this.credentialMap.containsKey(username)
                && this.credentialMap.get(username).equals(encodedPassword)) {
            return true;
        }
        return false;
    }

    public boolean isCredentialValid(String username, String password) throws LoginException, CredentialNotFoundException {
        if (!this.credentialMap.containsKey(username)) {
            throw new CredentialNotFoundException("The provided username does not exist in the credentials map");
        }

        String decodedPassword = new String(decoder.decode(this.credentialMap.get(username)));
        return this.validateCredential(username, decodedPassword);
    }

}