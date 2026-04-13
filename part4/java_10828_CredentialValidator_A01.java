public class java_10828_CredentialValidator_A01 {
    // Database is a hardcoded user and password
    private static String[][] Database = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"}
    };

    // Credentials to validate
    private String user;
    private String password;

    public java_10828_CredentialValidator_A01(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean validate() {
        // Use a simple comparison to check user and password against the database
        for (int i = 0; i < Database.length; i++) {
            if (Database[i][0].equals(this.user) && Database[i][1].equals(this.password)) {
                return true;
            }
        }
        return false;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator("user1", "password1");
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}