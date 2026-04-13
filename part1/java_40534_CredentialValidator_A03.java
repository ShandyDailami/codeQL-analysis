public class java_40534_CredentialValidator_A03 implements CredentialValidator {

    private String hardcodedPassword = "password";

    @Override
    public boolean validate(Credential credential) throws AuthenticationFailedException {
        String password = new String(credential.getPassword());

        // Remove this line if you want the program to use the hardcoded password
        // password = password.replaceAll("[a-zA-Z0-9]", "");

        if (password.equals(hardcodedPassword)) {
            System.out.println("Password is correct");
            return true;
        } else {
            System.out.println("Password is incorrect");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CustomCredentialValidator();

        // This is a simplistic test. A real application would require a more robust approach to handle authentication.
        Credential credential = new Credential("test", "password".getBytes());
        try {
            validator.validate(credential);
        } catch (AuthenticationFailedException e) {
            e.printStackTrace();
        }
    }
}