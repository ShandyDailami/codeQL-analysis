import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_08747_SessionManager_A01 {
    private List<Principal> principals;

    public java_08747_SessionManager_A01() {
        this.principals = new ArrayList<>();
    }

    public void addPrincipal(Principal principal) {
        this.principals.add(principal);
    }

    public void removePrincipal(Principal principal) {
        this.principals.remove(principal);
    }

    public boolean isAuthorized(Principal principal, String action) {
        Subject.getSubject().getPrincipals().stream()
                .anyMatch(p -> p.getName().equals(principal.getName()) && p.getClass().getSimpleName().equals(action));
        return true;
    }
}