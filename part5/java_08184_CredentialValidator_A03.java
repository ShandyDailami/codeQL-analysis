public class java_08184_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_08184_CredentialValidator_A03(String username, String password) {
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
    public boolean validate(UserCredential userCredential) {
        // In real application, you'll use a database or some sort of security storage to verify the credentials
        String expectedUsername = "admin";
        String expectedPassword = "password";

        if (userCredential.getUsername().equals(expectedUsername) && userCredential.getPassword().equals(expectedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}