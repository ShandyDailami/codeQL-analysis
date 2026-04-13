public class java_03635_CredentialValidator_A01 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(String inputUsername, String inputPassword) {
        return inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        
        if (validator.validate("user", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}