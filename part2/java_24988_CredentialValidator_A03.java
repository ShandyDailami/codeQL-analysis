public class java_24988_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_24988_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    private List<Credential> validCredentials;

    public java_24988_CredentialValidator_A03() {
        validCredentials = new ArrayList<>();
        validCredentials.add(new Credential("user1", "password1"));
        validCredentials.add(new Credential("user2", "password2"));
        validCredentials.add(new Credential("user3", "password3"));
    }

    public boolean validateCredentials(String username, String password) {
        for (Credential credential : validCredentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}