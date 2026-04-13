public class java_17115_CredentialValidator_A07 {
    private String[][] credentialData = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public boolean validateCredentials(String username, String password) {
        boolean isValid = false;

        for (int i = 0; i < credentialData.length; i++) {
            if (credentialData[i][0].equals(username) && credentialData[i][1].equals(password)) {
                isValid = true;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid username or password.");
        }

        return isValid;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user4", "password4");
    }
}