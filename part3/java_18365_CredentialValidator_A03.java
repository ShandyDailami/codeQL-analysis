public class java_18365_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        if (credentials == null) {
            return false;
        }

        if ("".equals(credentials.getUsername()) || "".equals(credentials.getPassword())) {
            return false;
        }

        if (USERNAME.equals(credentials.getUsername()) && PASSWORD.equals(credentials.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new MinimalCredentialValidator();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("test", "password");
        boolean valid = validator.validate(credentials);
        System.out.println("Is valid: " + valid);
    }
}