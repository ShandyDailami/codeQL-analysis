public class java_16204_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_16204_CredentialValidator_A03(String username, String password) {
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
    private User expectedUser;

    public java_16204_CredentialValidator_A03(String expectedUsername, String expectedPassword) {
        this.expectedUser = new User(expectedUsername, expectedPassword);
    }

    public boolean isValid(String username, String password) {
        User providedUser = new User(username, password);
        return this.expectedUser.getUsername().equals(providedUser.getUsername()) 
            && this.expectedUser.getPassword().equals(providedUser.getPassword());
    }
}