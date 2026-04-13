public class java_05772_CredentialValidator_A08 {
    private String[][] credentials = {
        {"user1", "pass1"},
        {"user2", "pass2"},
        {"user3", "pass3"},
    };

    public boolean validate(String username, String password) {
        for (String[] credential : credentials) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("user1", "pass1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.validate("user4", "pass4")) {
            System.out.println("Access granted for user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}