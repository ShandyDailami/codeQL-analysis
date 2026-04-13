import java.util.HashMap;

public class java_27415_CredentialValidator_A07 {

    private HashMap<String, String> credentials;

    public java_27415_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) &&
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}