import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Collection;
import java.util.Map;

@Service
public class java_20395_SessionManager_A07 {

    @Autowired
    private HttpSession httpSession;

    public void createSession() {
        httpSession.setAttribute("test", "testValue");
    }

    public void deleteSession() {
        httpSession.invalidate();
    }

    public Collection<Map<String, Object>> getAllSessions() {
        return httpSession.getAttributeNames();
    }

    public boolean isSessionActive() {
        return httpSession.getAttribute("test") != null;
    }

    public HttpSessionContext getSessionContext() {
        return httpSession.getSessionContext();
    }

}