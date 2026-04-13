public class java_28176_CredentialValidator_A01 {
    // field for user's password
    private String password;

    // constructor
    public java_28176_CredentialValidator_A01(String password) {
        this.password = password;
    }

    // method to validate password
    public boolean validatePassword(String enteredPassword) {
        // check if entered password and password stored in object match
        if (enteredPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // create a new CredentialValidator object with a hard-coded password
        CredentialValidator validator = new CredentialValidator("123456");

        // check if the password is valid
        if (validator.validatePassword("123456")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}