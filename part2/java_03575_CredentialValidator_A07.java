public class java_03575_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_03575_CredentialValidator_A07(String username, String password) {
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

    public java_03575_CredentialValidator_A07(User[] users) {
        this.users = users;
    }

    public User validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}