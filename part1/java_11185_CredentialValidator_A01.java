public class java_11185_CredentialValidator_A01 {
    private String[][] credentialData = {
        {"username1", "password1"},
        {"username2", "password2"},
        {"username3", "password3"},
    };

    public boolean validate(String username, String password) {
        for (String[] credential : credentialData) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validate("username1", "password1");
        System.out.println("Is valid? " + isValid);

        isValid = validator.validate("username2", "wrongpassword");
        System.out.println("Is valid? " + isValid);

        isValid = validator.validate("nonexistentuser", "nonexistentpassword");
        System.out.println("Is valid? " + isValid);
    }
}