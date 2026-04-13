public class java_20301_CredentialValidator_A03 implements CredentialValidator {

    // List of predefined usernames
    private List<String> predefinedUsernames = Arrays.asList("admin", "user1", "user2", "user3");

    @Override
    public boolean validate(String username, String password) {
        // Check if the username is in the list of predefined usernames
        if (predefinedUsernames.contains(username)) {
            System.out.println("Username " + username + " is valid");
            return true;
        } else {
            System.out.println("Username " + username + " is invalid");
            return false;
        }
    }
}