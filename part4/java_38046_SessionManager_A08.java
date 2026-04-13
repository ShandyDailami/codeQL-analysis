import java.util.ArrayList;
import java.util.List;

public class java_38046_SessionManager_A08 {
    // A list to hold all active sessions
    private List<Session> sessions = new ArrayList<>();

    // A list to hold all active users
    private List<User> users = new ArrayList<>();

    // A list to hold all active roles
    private List<Role> roles = new ArrayList<>();

    public java_38046_SessionManager_A08() {
        // Create sample data for sessions, users, and roles
        sessions.add(new Session(1, "Session1", "Created By User1", new Role(1, "Admin")));
        sessions.add(new Session(2, "Session2", "Created By User2", new Role(2, "User")));

        users.add(new User(1, "User1", "Password1", "User1"));
        users.add(new User(2, "User2", "Password2", "User2"));

        roles.add(new Role(1, "Admin"));
        roles.add(new Role(2, "User"));
    }

    public Session createSession(String name, String description, Role role) {
        // Simulate a security-sensitive operation to verify the role of the user
        if (role.getName().equals("Admin")) {
            // If the user is an admin, allow the session to be created
            Session session = new Session(name, description, role);
            sessions.add(session);
            return session;
        } else {
            // If the user is not an admin, deny the operation
            throw new SecurityException("User is not authorized to create a session");
        }
    }

    public void deleteSession(int id) {
        // Simulate a security-sensitive operation to verify the integrity of the session
        for (Session session : sessions) {
            if (session.getId() == id) {
                if (session.getCreatedBy().getRole().getName().equals("Admin")) {
                    sessions.remove(session);
                    break;
                } else {
                    throw new SecurityException("User is not authorized to delete the session");
                }
            }
        }
    }
}