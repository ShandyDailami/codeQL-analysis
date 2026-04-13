import java.util.HashMap;
import java.util.Map;

public class java_31829_CredentialValidator_A08 {
    private Map<String, String> userDataMap;

    public java_31829_CredentialValidator_A08() {
        userDataMap = new HashMap<>();
        userDataMap.put("user1", "password1"); // This is a dummy data
        userDataMap.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if(userDataMap.containsKey(username) && userDataMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}