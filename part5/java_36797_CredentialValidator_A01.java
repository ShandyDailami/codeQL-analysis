import java.security.Permission;
import java.security.SecurityManager;
import java.security.PrivilegedAction;

public class java_36797_CredentialValidator_A01 extends SecurityManager {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public boolean checkUser(String user) {
        return USERNAME.equals(user);
    }

    @Override
    public boolean checkPassword(String pass) {
        return PASSWORD.equals(pass);
    }

    @Override
    public boolean checkPermission(Permission perm) {
        return false;
    }

    @Override
    public boolean checkAccess(String context) {
        return false;
    }

    public static void main(String[] args) {
        SecurityManager sm = new CustomSecurityManager();

        sm.runAs(new PrivilegedAction<Void>() {
            public Void run() {
                boolean valid = sm.check(new PrivilegedAction<Boolean>() {
                    public Boolean run() {
                        return sm.checkUser("user") && sm.checkPassword("password");
                    }
                });

                if (valid) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
                return null;
            }
        });
    }
}