public class java_12897_CredentialValidator_A08 {

    private String correctPassword; // This variable holds the correct password

    public java_12897_CredentialValidator_A08(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    public boolean validate(String password) { // This method checks if the given password is correct
        return password.equals(correctPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("correctPassword");

        if(validator.validate("wrongPassword")) {
            System.out.println("Wrong password!");
        } else {
            System.out.println("Access granted!");
        }

        if(validator.validate("correctPassword")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Wrong password!");
        }
    }
}