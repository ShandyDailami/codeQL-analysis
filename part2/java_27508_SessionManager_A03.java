import java.util.HashMap;
import java.util.Map;

public class java_27508_SessionManager_A03 {

    private Map<String, String> userMap;

    public java_27508_SessionManager_A03() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, encryptPassword(password));
    }

    public String getPassword(String username) {
        return decryptPassword(userMap.get(username));
    }

    private String encryptPassword(String password) {
        // This is a very simple encryption technique that is not secure for a real world application.
        return new StringBuilder(password).reverse().toString();
    }

    private String decryptPassword(String encryptedPassword) {
        // This is a very simple decryption technique that is not secure for a real world application.
        return new StringBuilder(encryptedPassword).reverse().toString();
   
    }
}