import java.security.AuthProvider;
import java.security.Security;

public class java_40826_CredentialValidator_A03 extends AuthProvider {

    private static final long serialVersionUID = 1L;

    @Override
    public String choosePassword(String user, String basePassword, String targetPassword) {
        return "Custom Password";
    }

    @Override
    public String choosePassword(String user, String basePassword, String targetPassword, String newPassword) {
        return "Custom Password";
    }

    @Override
    public String choosePassword(String user, String basePassword, String targetPassword, String newPassword, String newPasswordConfirmation) {
        return "Custom Password";
    }

    @Override
    public boolean validate(String user, String password) {
        return false;
    }

    @Override
    public boolean validate(String user, String password, String target) {
        return false;
    }

    @Override
    public boolean validate(String user, String password, String target, String authenticationToken) {
        return false;
    }

    @Override
    public boolean authenticate(String user, String password) {
        return false;
    }

    @Override
    public boolean authenticate(String user, String password, String target) {
        return false;
    }

    @Override
    public boolean authenticate(String user, String password, String target, String authenticationToken) {
        return false;
    }
}

public class CustomSecurity {

    public static void main(String[] args) {

        Security.addProvider(new CustomAuthProvider());

        String password = Security.getProperty("java.security.auth.password.provider");
        System.out.println("Custom password provider: " + password);
    }
}