import java.security.*;

public class java_12898_CredentialValidator_A01 {

    private static final String[] ACCESS_CONTROL_LIST = { "read", "write" };
    private static final SecurityManager securityManager = new SecurityManager();

    public static void main(String[] args) {
        // Create a new Credential
        Credential credential = new Credential("username", "password");

        // Verify access to the credential
        verifyAccess(credential);
    }

    private static void verifyAccess(Credential credential) {
        if (securityManager.getAccessControl(credential) != null) {
            for (String action : ACCESS_CONTROL_LIST) {
                if (!securityManager.getAccessControl(credential).check(new Action(action))) {
                    System.out.println("Access denied for action: " + action);
                    return;
                }
            }
            System.out.println("Access granted for action: " + action);
        } else {
            System.out.println("No access control list found for the credential");
        }
    }
}

class Credential {
    private String username;
    private String password;

    public java_12898_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters for username and password
}

class Action {
    private String action;

    public java_12898_CredentialValidator_A01(String action) {
        this.action = action;
    }

    // Implement equals and hashcode methods if required
}

class SecurityManager {
    private HashMap<Credential, AccessControlList> accessControlListMap = new HashMap<>();

    public AccessControlList getAccessControl(Credential credential) {
        return accessControlListMap.get(credential);
    }

    public void setAccessControl(Credential credential, AccessControlList accessControlList) {
        accessControlListMap.put(credential, accessControlList);
    }
}

class AccessControlList {
    private HashMap<Action, Boolean> actionPermissionMap = new HashMap<>();

    public boolean check(Action action) {
        return actionPermissionMap.get(action);
    }

    public void setCheck(Action action, boolean check) {
        actionPermissionMap.put(action, check);
    }
}