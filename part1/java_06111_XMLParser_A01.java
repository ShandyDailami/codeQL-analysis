import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.HashSet;
import java.util.Set;

public class java_06111_XMLParser_A01 {

    private final SecurityManager securityManager;

    public java_06111_XMLParser_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void parse(String xml) {
        Set<Permission> permissions = new HashSet<>();
        permissions.add(new ActionPermission("parse"));
        try {
            securityManager.checkPermission(permissions);
            // The parser starts here
            // ...
        } catch (AccessDeniedException e) {
            System.out.println("Access denied!");
        } catch (AccessControlException e) {
            System.out.println("Access control exception: " + e.getMessage());
        }
    }
}