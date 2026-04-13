public class java_31682_CredentialValidator_A01 implements CredentialValidator {

    private static final String[] WEAK_PASSWORDS = { "password", "123456", "qwerty", "admin" };

    @Override
    public boolean validate(String username, String password) {
        boolean isWeakPassword = false;

        // Check password against a list of weak passwords
        for (String weakPassword : WEAK_PASSWORDS) {
            if (weakPassword.equals(password)) {
                isWeakPassword = true;
                break;
            }
        }

        if (isWeakPassword) {
            System.out.println("Access denied for " + username + " (password is weak)");
        } else {
            System.out.println("Access granted for " + username);
        }

        // Return true if the password is weak
        return isWeakPassword;
    }
}