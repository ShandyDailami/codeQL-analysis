import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class java_36677_SessionManager_A03 {

    private List<Principal> principals;

    public java_36677_SessionManager_A03() {
        this.principals = new ArrayList<>();
    }

    public void addPrincipal(Principal principal) {
        this.principals.add(principal);
    }

    public void removePrincipal(Principal principal) {
        this.principals.remove(principal);
    }

    public void checkSession(Subject subject) {
        List<String> roles = Arrays.asList(subject.getPrincipal().getAttributes().get("role").toString().split(", "));

        for (String role : roles) {
            switch (role) {
                case "admin":
                    System.out.println("Access granted to admin");
                    break;
                case "user":
                    System.out.println("Access granted to user");
                    break;
                default:
                    System.out.println("Access denied for " + role);
                    break;
            }
        }
    }
}