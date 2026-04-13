import java.util.HashMap;

public class java_04325_CredentialValidator_A01 {
    private HashMap<String, String> credentials;

    public java_04325_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}