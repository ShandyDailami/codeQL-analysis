import java.util.HashMap;
import java.util.Map;

public class java_36789_SessionManager_A03 implements Session {
    private Map<String, Object> sessionData;

    public java_36789_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    @Override
    public void setAttribute(String name, Object value) {
        sessionData.put(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return sessionData.get(name);
    }

    @Override
    public void invalidate() {
        sessionData.clear();
    }
}