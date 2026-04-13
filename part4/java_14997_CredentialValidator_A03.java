public class java_14997_CredentialValidator_A03 {

    private static final String[] PASSWORDS = {"password1", "password2", "password3", "password4", "password5"};

    public boolean validateCredentials(String userName, String password) {
        if (password == null || userName == null) {
            return false;
        }

        // Simulate database by comparing password with a hard-coded set of passwords
        for (String pwd : PASSWORDS) {
            if (pwd.equals(password)) {
                System.out.println("Credentials match! Validating as user: " + userName);
                return true;
            }
        }

        System.out.println("Credentials do not match. Validation failed as user: " + userName);
        return false;
    }
}