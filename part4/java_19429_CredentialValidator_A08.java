public class java_19429_CredentialValidator_A08 {

    private static final String USERNAME = "John";
    private static final String PASSWORD = "Password";

    public interface Credential {
        String getUsername();
        String getPassword();
    }

    public static CredentialValidator create() {
        return new CredentialValidator();
    }

    private java_19429_CredentialValidator_A08() {
        // private constructor to restrict instantiation
    }

    public boolean validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = create();
        validator.validate(new Credential() {
            public String getUsername() {
                return USERNAME;
            }

            public String getPassword() {
                return PASSWORD;
            }
        });

        validator.validate(new Credential() {
            public String getUsername() {
                return "Invalid";
            }

            public String getPassword() {
                return "Invalid";
            }
        });
    }
}