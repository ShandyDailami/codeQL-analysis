public class java_19645_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_19645_CredentialValidator_A01(String username, String password) {
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
    // Assuming that we have a Credential object stored in a secure place
    private Credential storedCredential;

    // Constructor
    public java_19645_CredentialValidator_A01(Credential storedCredential) {
        this.storedCredential = storedCredential;
    }

    public boolean validate(String username, String password) {
        if (storedCredential.getUsername().equals(username) && storedCredential.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}