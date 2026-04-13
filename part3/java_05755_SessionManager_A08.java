import java.util.HashMap;
import java.util.UUID;

public class java_05755_SessionManager_A08 {

    // A HashMap to hold session information. Each session is stored as a UUID and a String.
    private HashMap<UUID, String> sessionMap;

    // A HashMap to hold user information. Each user is stored as a UUID and a String.
    private HashMap<UUID, String> userMap;

    // A HashMap to hold user permissions. Each permission is stored as a UUID and a String.
    private HashMap<UUID, String> permissionMap;

    // A HashMap to hold user sessions. Each session is stored as a UUID and a UUID.
    private HashMap<UUID, UUID> sessionUserMap;

    // Constructor that initializes all the HashMaps.
    public java_05755_SessionManager_A08() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
        permissionMap = new HashMap<>();
        sessionUserMap = new HashMap<>();
    }

    // Method that creates a new session for a user.
    public UUID createSession(UUID userID) {
        UUID sessionID = UUID.randomUUID();
        sessionMap.put(sessionID, "active");
        userMap.put(userID, sessionID.toString());
        sessionUserMap.put(sessionID, userID);
        return sessionID;
    }

    // Method that checks if a session is active.
    public boolean isActiveSession(UUID sessionID) {
        return sessionMap.get(sessionID).equals("active");
    }

    // Method that gets the user associated with a session.
    public UUID getUser(UUID sessionID) {
        return sessionUserMap.get(sessionID);
    }

    // Method that deletes a session.
    public void deleteSession(UUID sessionID) {
        UUID userID = sessionUserMap.get(sessionID);
        sessionMap.remove(sessionID);
        userMap.remove(userID);
        sessionUserMap.remove(sessionID);
    }

    // Method that validates a user's session.
    public boolean validateSession(UUID sessionID, String hash) {
        UUID userID = sessionUserMap.get(sessionID);
        String sessionHash = sessionMap.get(sessionID);
        return sessionHash.equals(hash) && userID != null;
    }

    // Method that creates a new permission for a user.
    public UUID createPermission(UUID userID) {
        UUID permissionID = UUID.randomUUID();
        permissionMap.put(permissionID, "active");
        userMap.put(userID, permissionID.toString());
        return permissionID;
    }

    // Method that checks if a permission is active.
    public boolean isActivePermission(UUID permissionID) {
        return permissionMap.get(permissionID).equals("active");
    }

    // Method that gets the user associated with a permission.
    public UUID getUser(UUID permissionID) {
        return userMap.get(permissionID).isEmpty() ? null : UUID.fromString(userMap.get(permissionID));
    }

    // Method that deletes a permission.
    public void deletePermission(UUID permissionID) {
        UUID userID = userMap.get(permissionID);
        permissionMap.remove(permissionID);
        userMap.remove(userID);
    }

    // Method that validates a user's permission.
    public boolean validatePermission(UUID permissionID, String hash) {
        UUID userID = userMap.get(permissionID);
        String permissionHash = permissionMap.get(permissionID);
        return permissionHash.equals(hash) && userID != null;
    }
}