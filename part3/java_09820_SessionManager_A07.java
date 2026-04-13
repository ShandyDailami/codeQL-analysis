import java.util.HashMap;
import java.util.Map;

public class java_09820_SessionManager_A07 {

    // This is a simple in-memory representation of a database
    private Map<String, String> userDatabase;

    public java_09820_SessionManager_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");
    }

    public String getPassword(String user) {
        return userDatabase.get(user);
    }

    public boolean validateUser(String user, String password) {
        String dbPassword = userDatabase.get(user);
        if (dbPassword == null) {
            // This user does not exist in our database
            return false;
        }

        // Check the provided password against the stored password
        return dbPassword.equals(password);
    }
}