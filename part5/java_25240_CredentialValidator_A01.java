public class java_25240_CredentialValidator_A01 {

    private String[][] users = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
    };

    public boolean validate(String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validate("user1", "password1");
        System.out.println("User is valid: " + isValid);

        isValid = validator.validate("user4", "password4");
        System.out.println("User is valid: " + isValid);
    }
}