public class java_32118_CredentialValidator_A03 {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");
    }

    public static class CredentialValidator {
        public void validate(String username, String password) {
            if ("admin".equals(username) && "password".equals(password)) {
                System.out.println("Credentials validated successfully!");
            } else {
                System.out.println("Credentials invalid!");
            }
        }
    }
}