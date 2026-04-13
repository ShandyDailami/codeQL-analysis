import java.util.Base64;
import java.util.Map;

public class java_13957_CredentialValidator_A07 {

    private Map<String, String> credentialMap;

    public java_13957_CredentialValidator_A07(Map<String, String> credentialMap) {
        this.credentialMap = credentialMap;
    }

    public boolean isValid(String userName, String password) {
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        String expectedPassword = credentialMap.get(userName);
        
        if (expectedPassword == null) {
            return false;
        }
        
        if (decodedPassword.equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}