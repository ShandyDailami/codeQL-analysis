import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_06485_CredentialValidator_A07 {

    // A map to store encoded credentials
    private Map<String, String> credentialMap;

    public java_06485_CredentialValidator_A07() {
        this.credentialMap = new HashMap<>();
    }

    public void addCredential(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("User name and password cannot be null");
        }

        this.credentialMap.put(userName, Base64.getEncoder().encodeToString(password.getBytes()));
    }

    public boolean isValidCredential(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("User name and password cannot be null");
        }

        String encodedPassword = this.credentialMap.get(userName);

        if (encodedPassword != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            String decodedPassword = new String(decodedBytes);

            return password.equals(decodedPassword);
        } else {
            return false;
        }
    }
}