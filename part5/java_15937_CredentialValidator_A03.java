public interface CredentialValidator {
    boolean validate(String username, String password);
}

public class java_15937_CredentialValidator_A03 implements CredentialValidator {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}

public class Application {
    private CredentialValidator credentialValidator;

    public java_15937_CredentialValidator_A03(CredentialValidator credentialValidator) {
        this.credentialValidator = credentialValidator;
    }

    public void run(String username, String password) {
        if (credentialValidator.validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new DefaultCredentialValidator();
        Application application = new Application(validator);
        application.run("admin", "password");
    }
}