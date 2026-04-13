import java.util.HashSet;
import java.util.Set;

public class java_13011_CredentialValidator_A03 implements CredentialValidator {

    private Set<String> adminUsers;
    private Set<String> readUsers;
    private Set<String> writeUsers;

    public java_13011_CredentialValidator_A03() {
        adminUsers = new HashSet<>();
        readUsers = new HashSet<>();
        writeUsers = new HashSet<>();
    }

    public void addAdmin(String username) {
        adminUsers.add(username);
    }

    public void addRead(String username) {
        readUsers.add(username);
    }

    public void addWrite(String username) {
        writeUsers.add(username);
    }

    @Override
    public boolean isValid(String username, String password) {
        if (adminUsers.contains(username) && password.equals("password")) {
            return true;
        }

        if (readUsers.contains(username) && password.equals("readpassword")) {
            return true;
        }

        if (writeUsers.contains(username) && password.equals("writepassword")) {
            return true;
        }

        return false;
    }
}