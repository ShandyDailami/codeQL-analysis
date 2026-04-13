public class java_06862_CredentialValidator_A03 {
    public boolean isValid(String username) {
        // The specific string to check for a potential SQL injection attack
        String attackString = "DROP TABLE users;";

        // Check if the username contains the attack string
        if (username.contains(attackString)) {
            System.out.println("Detected SQL injection attack!");
            return false;
        }

        System.out.println("Username is valid: " + username);
        return true;
    }
}