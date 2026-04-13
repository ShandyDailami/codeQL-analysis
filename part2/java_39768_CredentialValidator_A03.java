public class java_39768_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_39768_CredentialValidator_A03(String username, String password) {
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
    public boolean validate(Credential credential) {
        // You can use a real database or service to get the user and password
        // For the sake of simplicity, let's just use hardcoded values
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        if (credential.getUsername().equals(hardcodedUsername) &&
                credential.getPassword().equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}