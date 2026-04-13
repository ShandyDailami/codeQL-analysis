public class java_08786_CredentialValidator_A07 {

    // In a real application, this method would be called with the submitted username and password
    // and a Credential object would be created with the returned credentials (username, password)
    public Credential validate(String username, String password) {

        if (username.equals("admin") && password.equals("admin")) {
            return new Credential(username, password);
        } else {
            throw new AuthFailureException();
        }
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        try {
            validator.validate("admin", "admin");
            System.out.println("Validated successfully!");
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed!");
        }
    }
}