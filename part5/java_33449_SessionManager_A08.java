import java.util.HashMap;
import java.util.Map;

public class java_33449_SessionManager_A08 implements Session {
    private Map<String, Object> sessionData;

    public java_33449_SessionManager_A08() {
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
    public void removeAttribute(String name) {
        sessionData.remove(name);
    }

    @Override
    public boolean isActive() {
        // Here you can add session security measures
        // For simplicity, we just return true here
        return true;
    }
}