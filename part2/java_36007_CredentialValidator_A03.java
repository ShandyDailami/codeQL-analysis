import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.AuthStatus;
import javax.security.auth.message.AuthException;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.Guard;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_36007_CredentialValidator_A03 {

    private String user;
    private String password;
    private String expectedPassword;

    public java_36007_CredentialValidator_A03(String user, String password) {
        this.user = user;
        this.password = password;
        this.expectedPassword = null;
    }

    public Set<Permission> getPermissions(Set<Permission> s) throws AuthException {
        return new HashSet<Permission>();
    }

    public Set<Permission> getGrantedPermissionsFor(String s) throws AuthException {
        return new HashSet<Permission>();
    }

    public Set<? extends Permission> getRequiredPermissionSet() throws AuthException {
        return new HashSet<Permission>();
    }

    public String getRequestedUsername() {
        return user;
    }

    public Subject getSubject() {
        return null;
    }

    public String getCallerPrincipal() {
        return null;
    }

    public boolean implies(Subject subject, String permission) {
        return false;
    }

    public boolean implies(Subject subject, String permission, Object context) {
        return false;
    }

    public boolean checkPermission(Subject subject, String permission) throws AuthException {
        return false;
    }

    public boolean checkPermission(Subject subject, String permission, Object context) throws AuthException {
        return false;
    }

    public Credential authenticate(String userName, String password) throws LoginException {
        if (userName.equals(this.user) && password.equals(this.password)) {
            return new UsernamePasswordCredential(userName, password);
        } else {
            throw new LoginException("Authentication failed");
        }
    }

    public void validate(Action<? super Subject> action) throws AuthException {
        action.execute(Subject.emptySubject());
    }

    public Subject getSubject(Action<? super Subject> action) throws AuthException {
        return Subject.emptySubject();
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");
        validator.validate(subject -> {});
    }
}