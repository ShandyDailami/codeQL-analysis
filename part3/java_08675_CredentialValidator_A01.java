public class java_08675_CredentialValidator_A01 {
    // This class is a simple CredentialValidator example.
    // It's not a real-world example, it's just meant to demonstrate the concept.

    private static class Credentials {
        private final String username;
        private final String password;

        public java_08675_CredentialValidator_A01(String username, String password) {
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

    private static Credentials currentCredentials = null;

    public static Credentials getCurrentCredentials() {
        return currentCredentials;
    }

    public static void setCurrentCredentials(Credentials credentials) {
        currentCredentials = credentials;
    }

    public static boolean validate(String username, String password) {
        if (currentCredentials == null) {
            setCurrentCredentials(new Credentials(username, password));
            return true;
        } else if (currentCredentials.getUsername().equals(username) &&
                    currentCredentials.getPassword().equals(password)) {
            return true;
        } else {
            setCurrentCredentials(null);
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Logging in as user1");
        if (validate("user1", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        System.out.println("Logging in as user2");
        if (validate("user2", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}