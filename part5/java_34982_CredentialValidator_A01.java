public class java_34982_CredentialValidator_A01 {

    // Predefined set of users
    private static final String[][] users = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" },
        // add more users as needed
    };

    // Credentials to validate
    private String username;
    private String password;

    public java_34982_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user1", "password1");
        if (validator.validate()) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}