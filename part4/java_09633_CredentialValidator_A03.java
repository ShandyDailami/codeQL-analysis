import java.util.Base64;
import java.util.Map;

public class java_09633_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_09633_CredentialValidator_A03(Map<String, String> userCredentials) {
        this.userCredentials = userCredentials;
    }

    public boolean validateCredentials(String username, String password) {
        String decodedPassword = new String(Base64.getDecoder().decode(userCredentials.get(username)));
        return password.equals(decodedPassword);
    }
}