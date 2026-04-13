import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class java_15001_SessionManager_A03 {
    private static List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");

    public void validateUser(String userName) {
        if (!allowedUsers.contains(userName)) {
            throw new SecurityException("Unauthorized user attempt: " + userName);
        }
    }

    public void validateSession(Subject subject) {
        List<String> users = subject.getPrincipals().stream()
                .map(principal -> ((javax.security.auth.UsernamePasswordAuthenticationToken) principal).getName())
                .collect(Collectors.toList());

        if (users.size() > 0 && !allowedUsers.contains(users.get(0))) {
            throw new SecurityException("Invalid session: " + users);
        }
    }

    public void performAction(Subject subject, String action) {
        validateUser(subject.getPrincipals().stream()
                .map(principal -> ((javax.security.auth.UsernamePasswordAuthenticationToken) principal).getName())
                .collect(Collectors.toList()).get(0));

        System.out.println("Performing action: " + action);
    }
}