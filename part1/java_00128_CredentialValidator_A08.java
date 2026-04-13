import java.security.SecurityPermission;
import java.security.GuardianPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Guardian;
import java.security.GuardianSecurityManager;

public class java_00128_CredentialValidator_A08 extends GuardianSecurityManager {
    private String password;

    public java_00128_CredentialValidator_A08(String password) {
        this.password = password;
    }

    @Override
    public PermissionCollection getPermissions(Guardian guardian) {
        PermissionCollection collection = super.getPermissions(guardian);

        if ("password".equals(guardian.getClass().getName())) {
            collection.addPermission(new SecurityPermission("resolveClassLoader"));
            collection.addPermission(new GuardianPermission("majorVersion"));
        }

        return collection;
    }

    @Override
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}