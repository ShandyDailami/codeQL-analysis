public class java_26890_CredentialValidator_A01 {

    // This is a placeholder for a real Credential object
    private Credential credential;

    public java_26890_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    public boolean validate() {
        // Validate the credential
        if (credential.getUsername().equals("admin") && credential.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }

}

// This is a placeholder for a real Credential object
public class Credential {

    private String username;
    private String password;

    public java_26890_CredentialValidator_A01(String username, String password) {
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