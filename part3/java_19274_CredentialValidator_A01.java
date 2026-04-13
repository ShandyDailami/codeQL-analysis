public class java_19274_CredentialValidator_A01 {

    private static final List<String> ADMIN_USERS = Arrays.asList("admin", "root", "administrator");

    public boolean validate(String username, String password) {
        // This is a simple example. In a real-world scenario, it would involve hashing the password and comparing it with the hashed password stored in the database
        return isAdminUser(username) && isValidPassword(password);
    }

    private boolean isAdminUser(String username) {
        return ADMIN_USERS.contains(username);
    }

    private boolean isValidPassword(String password) {
        // This is a placeholder. In a real-world scenario, you would actually need to check the password against a hash, not a plain text
        return true;
    }
}