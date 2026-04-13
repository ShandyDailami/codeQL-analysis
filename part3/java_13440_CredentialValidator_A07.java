import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_13440_CredentialValidator_A07 {

    private List<Credential> credentials;

    public java_13440_CredentialValidator_A07() {
        credentials = new ArrayList<>();
    }

    public void addCredential(Credential credential) {
        credentials.add(credential);
    }

    public boolean isValidCredential(String username, String password) {
        for (Credential credential : credentials) {
            if (credential.isValid(username, password)) {
                return true;
            }
        }
        return false;
    }

    public static class Credential {

        private String username;
        private String password;

        public java_13440_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean isValid(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();

        validator.addCredential(new LegacyCredentialValidator.Credential("user1", "password1"));
        validator.addCredential(new LegacyCredentialValidator.Credential("user2", "password2"));

        boolean isValid = validator.isValidCredential("user1", "password1");
        System.out.println("Is valid: " + isValid);

        isValid = validator.isValidCredential("user3", "password3");
        System.out.println("Is valid: " + isValid);
    }
}