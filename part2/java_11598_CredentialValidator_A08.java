public interface Credential {
    String getUsername();
    String getPassword();
}

public interface CredentialValidator {
    boolean validate(Credential credential);
}

public class java_11598_CredentialValidator_A08 implements CredentialValidator {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public boolean validate(Credential credential) {
        return VALID_USERNAME.equals(credential.getUsername()) 
            && VALID_PASSWORD.equals(credential.getPassword());
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new SimpleCredentialValidator();
        
        Credential user = new Credential() {
            @Override
            public String getUsername() {
                return "wrong_username";
            }

            @Override
            public String getPassword() {
                return "wrong_password";
            }
        };
        
        if (validator.validate(user)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}