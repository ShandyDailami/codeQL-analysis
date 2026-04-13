import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_01552_SessionManager_A01 {
    private List<Principal> principals;

    public java_01552_SessionManager_A01() {
        this.principals = new ArrayList<>();
    }

    public void addPrincipal(Principal principal) {
        this.principals.add(principal);
    }

    public void removePrincipal(Principal principal) {
        this.principals.remove(principal);
    }

    public Subject getSubject(Principal principal) {
        if (this.principals.contains(principal)) {
            return new Subject.publicKey(principal.getClass().newInstance(), new Subject.publicKey(principal.getClass().newInstance()));
        } else {
            return null;
        }
    }

    public Principal getPrincipal(Subject subject) {
        for (Principal principal : this.principals) {
            if (subject.getPublicKey().equals(principal.getPublicKey())) {
                return principal;
            }
        }
        return null;
    }
}