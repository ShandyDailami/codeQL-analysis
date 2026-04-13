import javax.management.RuntimeErrorException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class java_24553_SessionManager_A03 {
    private Map<String, Object> sessionMap;

    public java_24553_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String id, Object obj) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("Session id can not be null or empty");
        }
        this.sessionMap.put(id, obj);
    }

    public Object getSession(String id) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("Session id can not be null or empty");
        }
        return this.sessionMap.get(id);
    }

    public void updateSession(String id, Object obj) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("Session id can not be null or empty");
        }
        this.sessionMap.put(id, obj);
    }

    public void deleteSession(String id) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("Session id can not be null or empty");
        }
        this.sessionMap.remove(id);
    }

    public void invalidateSession(String id) {
        if (id == null || id.equals("")) {
            throw new IllegalArgumentException("Session id can not be null or empty");
        }
        this.sessionMap.remove(id);
    }
}