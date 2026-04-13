import javax.security.auth.Subject;
import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashSet;
import java.util.Set;

public class java_19371_SessionManager_A08 {
    private Set<Subject> authorizedSubjects;

    public java_19371_SessionManager_A08() {
        this.authorizedSubjects = new HashSet<>();
    }

    public void addAuthorizedSubject(Subject subject) {
        this.authorizedSubjects.add(subject);
    }

    public void removeAuthorizedSubject(Subject subject) {
        this.authorizedSubjects.remove(subject);
    }

    public Permission[] getPermissions(Subject subject) {
        if (!this.authorizedSubjects.contains(subject)) {
            return new SecurityPermission("SessionManager operations");
        }

        return new Permission[0];
    }

    public boolean checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) {
            return this.authorizedSubjects.contains(perm.getClass().newInstance());
        }

        return false;
    }

    public boolean implies(Subject subject, Permission perm) {
        if (perm instanceof SecurityPermission) {
            return this.authorizedSubjects.contains(subject);
        }

        return false;
    }
}