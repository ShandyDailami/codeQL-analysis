import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.GuardianSelector;
import java.security.PrivilegedAction;
import java.security.Guardian;

public class java_02858_CredentialValidator_A03 {

    private String username;
    private String password;

    public java_02858_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}