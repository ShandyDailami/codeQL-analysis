import java.util.Arrays;
import java.util.List;

public class java_05465_CredentialValidator_A07 {
    private List<Credential> credentialsList;

    public java_05465_CredentialValidator_A07() {
        this.credentialsList = Arrays.asList(
                new Credential("user1", "password1"),
                new Credential("user2", "password2"),
                new Credential("user3", "password3"));
    }

    public boolean validateCredentials(Credential credential) {
        return this.credentialsList.stream()
                .anyMatch(c -> c.getUsername().equals(credential.getUsername()) && c.getPassword().equals(credential.getPassword()));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Valid credentials
        System.out.println(validator.validateCredentials(new Credential("user1", "password1"))); // Should print: true

        // Invalid credentials
        System.out.println(validator.validateCredentials(new Credential("invalid", "password"))); // Should print: false
    }
}

class Credential {
    private String username;
    private String password;

    public java_05465_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}