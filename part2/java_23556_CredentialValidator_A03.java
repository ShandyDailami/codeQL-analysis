import com.example.User;

public class java_23556_CredentialValidator_A03 implements CredentialValidator {

    private static final User ADMIN = new User("admin", "password");

    @Override
    public boolean validate(String username, String password) {
        if (username.equals(ADMIN.getUsername()) && password.equals(ADMIN.getPassword())) {
            return true;
        }
        return false;
    }

}

interface CredentialValidator {

    boolean validate(String username, String password);

}