import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class java_39851_SessionManager_A07 {

    private Map<String, String> userDatabase;

    public java_39851_SessionManager_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public Optional<String> authenticate(String username, String password) {
        String passwordInDatabase = userDatabase.get(username);

        if (passwordInDatabase != null && passwordInDatabase.equals(password)) {
            return Optional.of(username);
        } else {
            return Optional.empty();
        }
    }

    public Optional<String> getResource(String username, String password) {
        return authenticate(username, password).map(user -> "Access granted to user: " + user);
    }

}