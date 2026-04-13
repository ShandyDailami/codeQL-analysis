public class java_21065_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_21065_CredentialValidator_A01(String username, String password) {
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
    private User[] users;

    public java_21065_CredentialValidator_A01(User[] users) {
        this.users = users;
    }

    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}