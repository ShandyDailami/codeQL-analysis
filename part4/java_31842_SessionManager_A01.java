import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class java_31842_SessionManager_A01 {
    private List<String> actions = new ArrayList<>();

    public void checkAccess(Subject subject, Object object) {
        // check if the object is accessible by the subject
        // if not accessible, throw an exception
        // otherwise, perform the actions
        if (!isAccessible(subject, object)) {
            throw new SecurityException("Access Denied");
        }
    }

    private boolean isAccessible(Subject subject, Object object) {
        // implement access control logic
        // if the object is accessible, return true
        // otherwise, return false
        return false;
    }

    public void executeActions() {
        // implement the actions
        // for example, log the actions
        for (String action : actions) {
            System.out.println("Executing action: " + action);
        }
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        // simulate a subject with access to a specific object
        Subject subject = new Subject();
        subject.getPrincipals().add(new Principal("User"));
        securityManager.checkAccess(subject, new Object());

        // simulate a subject without access to a specific object
        Subject unauthorizedSubject = new Subject();
        unauthorizedSubject.getPrincipals().add(new Principal("Unauthorized User"));
        try {
            securityManager.checkAccess(unauthorizedSubject, new Object());
        } catch (SecurityException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // simulate the execution of actions
        securityManager.actions.add("Log out");
        securityManager.actions.add("Edit profile");
        securityManager.executeActions();
    }
}