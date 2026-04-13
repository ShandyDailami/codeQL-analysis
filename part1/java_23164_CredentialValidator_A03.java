public class java_23164_CredentialValidator_A03 {

    // This is a dummy user object. In a real application,
    // this would be used to store and retrieve user information.
    private User user;

    public java_23164_CredentialValidator_A03() {
        this.user = new User("", "");
    }

    public User validate(String username, String password) {
        if ("admin".equals(username) && "password".equals(password)) {
            user.setUsername(username);
            user.setPassword(password);
            user.setValidated(true);
        } else {
            user.setValidated(false);
        }
        return user;
    }
}

class User {
    private String username;
    private String password;
    private boolean validated;

    public java_23164_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}