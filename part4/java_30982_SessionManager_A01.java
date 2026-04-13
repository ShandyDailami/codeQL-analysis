import java.util.HashMap;
import java.util.Map;

public class java_30982_SessionManager_A01 {

    private Map<String, String> userDatabase;

    public java_30982_SessionManager_A01() {
        this.userDatabase = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userDatabase.put(username, password);
    }

    public String getPassword(String username) {
        return userDatabase.get(username);
    }

    public boolean validateUser(String username, String password) {
        String dbPassword = userDatabase.get(username);
        return dbPassword != null && dbPassword.equals(password);
    }
}