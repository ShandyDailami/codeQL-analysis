import java.security.AccessControl;
import java.security.AccessControlListener;
import java.security.Subject;

public class java_19788_CredentialValidator_A01 implements AccessControlListener {

    private final String[] blacklist;

    public java_19788_CredentialValidator_A01(String[] blacklist) {
        this.blacklist = blacklist;
    }

    @Override
    public void checkPermission(Subject subject, Object o, String s) throws IllegalArgumentException, SecurityException {
        if (s != null && s.length() > 0 && contains(s)) {
            throw new SecurityException("Password is blacklisted: " + s);
        }
    }

    @Override
    public void grantPermission(Subject subject, Object o) {
        // Nothing to do
    }

    @Override
    public void checkActions(Subject subject, String actions[], boolean b) throws IllegalArgumentException, SecurityException {
        // Nothing to do
    }

    private boolean contains(String s) {
        for (String word : blacklist) {
            if (s.contains(word)) {
                return true;
            }
        }
        return false;
    }
}