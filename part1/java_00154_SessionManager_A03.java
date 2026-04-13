import java.util.HashMap;

public class java_00154_SessionManager_A03 {

    private HashMap<String, String> credentials;

    public java_00154_SessionManager_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        return this.credentials.containsKey(username) && 
               this.credentials.get(username).equals(password);
    }
}