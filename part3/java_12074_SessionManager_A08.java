import java.util.HashSet;
import java.util.Set;

public class java_12074_SessionManager_A08 {

    private final Set<String> allowedUsers = new HashSet<>();
    private final Set<String> allowedDomains = new HashSet<>();
    private final Set<String> allowedIps = new HashSet<>();

    public java_12074_SessionManager_A08() {
        // Initialize the allowed users, domains, and IPs
        allowedUsers.add("user1");
        allowedUsers.add("user2");

        allowedDomains.add("domain1.com");
        allowedDomains.add("domain2.com");

        allowedIps.add("192.168.1.1");
        allowedIps.add("192.168.1.2");
    }

    public boolean isAllowed(String user, String domain, String ip) {
        if (allowedUsers.contains(user)
                || allowedDomains.contains(domain)
                || allowedIps.contains(ip)) {
            return true;
        }
        return false;
    }

}

public class SessionManager {

    private final SecurityManager securityManager;

    public java_12074_SessionManager_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public void startSession(String user, String domain, String ip) {
        if (securityManager.isAllowed(user, domain, ip)) {
            // Start the session...
            System.out.println("Session started by " + user + " from " + domain + " (" + ip + ")");
        } else {
            System.out.println("Access denied for user " + user + " from " + domain + " (" + ip + ")");
        }
    }

}