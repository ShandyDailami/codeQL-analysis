import java.util.HashMap;
import java.util.Map;

public class java_27990_CredentialValidator_A01 {
    // A simple database to store users and their passwords
    private Map<String, String> userDatabase;

    public java_27990_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    // The validate method checks if a given username and password match our database
    public boolean validate(String username, String password) {
        return userDatabase.get(username).equals(password);
    }
}