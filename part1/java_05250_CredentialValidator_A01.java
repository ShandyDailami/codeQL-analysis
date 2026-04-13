import java.util.HashMap;
import java.util.Map;

public class java_05250_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_05250_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        return credentials.get(username).equals(password);
    }

}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean isValid = validator.validate("admin", "password");
        System.out.println("Is Valid? " + isValid);
    }

}