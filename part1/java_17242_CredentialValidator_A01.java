public interface Credential {
    String getUsername();
    String getPassword();
}

public interface CredentialValidator {
    boolean validate(Credential credential);
}

public class java_17242_CredentialValidator_A01 implements CredentialValidator {

    private List<String> allowedPasswords = Arrays.asList("password1", "password2", "password3");

    @Override
    public boolean validate(Credential credential) {
        String password = credential.getPassword();
        return password != null && password.length() >= 8 && allowedPasswords.contains(password);
    }
}

public class Main {

    public static void main(String[] args) {
        Credential credential = () -> "user", () -> "password1";
        CredentialValidator validator = new RealCredentialValidator();

        if (validator.validate(credential)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}