import java.security.Permission;
import java.security.SecurityManager;
import java.security.Guard;

public class java_39189_CredentialValidator_A01 implements SecurityManager {

    private String username;
    private String password;

    public java_39189_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Guard getGuard(String name) {
        return new Guard() {
            @Override
            public boolean implies(Permission permission) {
                // Always return true, as we are not using any permissions in this example
                return true;
            }
        };
    }

    @Override
    public boolean checkUser(String user) {
        return this.username.equals(user);
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}