public class java_25001_CredentialValidator_A01 implements CredentialValidator {

    private List<String> securePasswords;

    public java_25001_CredentialValidator_A01() {
        // Fetching a list of secure passwords here for demonstration purposes.
        // In real-world applications, this should be done in a secure manner.
        securePasswords = new ArrayList<>();
        securePasswords.add("secure123");
        securePasswords.add("topSecret");
        securePasswords.add("123456");
    }

    @Override
    public boolean validate(String username, String password) {
        if (securePasswords.contains(password)) {
            System.out.println("Access granted to user " + username);
            return true;
        } else {
            System.out.println("Access denied for user " + username);
            return false;
        }
    }
}