import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java_12000_SessionManager_A03 {

    private List<Principal> principals;

    public java_12000_SessionManager_A03() {
        this.principals = new ArrayList<>();
    }

    public void addPrincipal(Principal principal) {
        this.principals.add(principal);
    }

    public void removePrincipal(Principal principal) {
        this.principals.remove(principal);
    }

    public List<Principal> getPrincipals() {
        return this.principals;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Adding principals
        sessionManager.addPrincipal(new PrincipalImpl("User1"));
        sessionManager.addPrincipal(new PrincipalImpl("User2"));

        // Getting principals
        List<Principal> principals = sessionManager.getPrincipals();
        for (Principal principal : principals) {
            System.out.println(principal.getName());
        }

        // Removing principal
        sessionManager.removePrincipal(new PrincipalImpl("User1"));

        // Checking if the principal is removed
        if (sessionManager.getPrincipals().isEmpty()) {
            System.out.println("All principals are removed");
        }
    }
}

class PrincipalImpl implements Principal {

    private String name;

    public java_12000_SessionManager_A03(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}