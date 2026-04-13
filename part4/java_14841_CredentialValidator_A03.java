public class java_14841_CredentialValidator_A03 {
    // Validate a username and password.
    public boolean validate(String username, String password) {
        if (username == null || username.isEmpty()) {
            return false;
        }

        if (password == null || password.isEmpty()) {
            return false;
        }

        // Remove any commands or SQL commands from the username
        String sanitizedUsername = username.replace(";", "").replace("--", "").replace("/*", "").replace("*/", "").replace(" ", "");

        if (sanitizedUsername.contains("DROP") || sanitizedUsername.contains("DELETE") || sanitizedUsername.contains("INSERT") || sanitizedUsername.contains("UPDATE") || sanitizedUsername.contains("SELECT") || sanitizedUsername.contains("CREATE") || sanitizedUsername.contains("ALTER") || sanitizedUsername.contains("COMMIT") || sanitizedUsername.contains("ROLLBACK")) {
            return false;
        }

        if (sanitizedUsername.contains("'") || sanitizedUsername.contains("\"")) {
            return false;
        }

        return true;
    }
}