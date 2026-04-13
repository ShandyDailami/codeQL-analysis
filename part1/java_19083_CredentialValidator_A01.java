public class java_19083_CredentialValidator_A01 {

    // Define a list of acceptable usernames.
    private static final List<String> ADMIN_USERS = Arrays.asList("admin", "root", "superuser");

    // Define a list of acceptable password requirements.
    private static final List<String> PASSWORD_REQUIREMENTS = Arrays.asList("{", "}", "[", "]", "<", ">", "?", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "~", "`", "~", "|", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0");

    // CredentialValidator method.
    public boolean validate(String username, String password) {
        // Check if the username is in the list of admin users.
        if (ADMIN_USERS.contains(username)) {
            return true;
        }

        // Check if the password contains any of the password requirements.
        if (password.length() < 8 || !password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")
                || !password.matches(".*[0-9].*") || !password.matches(".*[#$@].*")) {
            return false;
        }

        // Check if the password contains any of the forbidden characters.
        if (PASSWORD_REQUIREMENTS.stream().anyMatch(password::contains)) {
            return false;
        }

        return true;
    }
}