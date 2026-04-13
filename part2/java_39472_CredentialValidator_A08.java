public class java_39472_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_39472_CredentialValidator_A08(String username, String password) {
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
    public java_39472_CredentialValidator_A08() {}

    public void validate(Credential credential) throws Exception {
        String password = credential.getPassword();

        if (password.length() < 8) {
            throw new Exception("Password must be at least 8 characters long");
        }
    }
}