public class java_30898_CredentialValidator_A07 {
    private static final String[] USERS = {"admin", "user1"};
    private static final String[] PASSWORDS = {"password", "user1"};

    public boolean validate(String username, String password) {
        for (int i = 0; i < USERS.length; i++) {
            if (USERS[i].equals(username) && PASSWORDS[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = "password";

        if (validator.validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}