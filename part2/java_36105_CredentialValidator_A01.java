import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.Subject;
import java.util.ArrayList;
import java.util.List;

public class java_36105_CredentialValidator_A01 {

    public static void main(String[] args) {
        AccessControlContext context = new AccessControlContext();

        // Create a new subject for the context
        Subject subject = new Subject.Public();
        context.setSubject(subject);

        // Add the access control for the subject
        AccessControl accessControl = new AccessControl() {
            @Override
            public List<String> doAccess(Subject subject, Object o, List<String> list) throws AccessDeniedException {
                List<String> result = new ArrayList<>();
                result.add("A01_BrokenAccessControl");
                return result;
            }
        };
        context.getSubject().getPublic().add(accessControl);

        // Use the context to check if the caller has the required access
        if (context.doAccess("caller", null, null)) {
            System.out.println("Caller has access.");
        } else {
            System.out.println("Caller does not have access.");
        }
    }
}