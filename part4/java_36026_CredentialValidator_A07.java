public class java_36026_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_36026_CredentialValidator_A07(String username, String password) {
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
    private User user;

    public java_36026_CredentialValidator_A07(String username, String password) {
        user = new User(username, password);
    }

    public boolean validate() {
        if (user.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}