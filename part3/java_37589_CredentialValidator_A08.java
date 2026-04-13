import java.util.HashMap;

public class java_37589_CredentialValidator_A08 {
    private HashMap<String, String> userMap;

    public java_37589_CredentialValidator_A08() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if(userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}