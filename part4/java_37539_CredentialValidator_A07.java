public class java_37539_CredentialValidator_A07 {
    public interface Validator {
        boolean validate(String username, String password);
    }

    private Validator validator;

    public java_37539_CredentialValidator_A07(Validator validator) {
        this.validator = validator;
    }

    public void login(String username, String password) {
        if (validator.validate(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}