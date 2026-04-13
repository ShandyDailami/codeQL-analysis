import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class java_19090_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_19090_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = RandomStringUtils.randomAlphanumeric(10);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (StringUtils.isNotBlank(sessionId) && sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void destroySession(String sessionId) {
        if (StringUtils.isNotBlank(sessionId) && sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}