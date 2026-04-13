public class java_01303_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_01303_CredentialValidator_A01(String username, String password) {
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
    private List<User> users = new ArrayList<>();

    public java_01303_CredentialValidator_A01() {
        users.add(new User("admin", "password"));
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
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