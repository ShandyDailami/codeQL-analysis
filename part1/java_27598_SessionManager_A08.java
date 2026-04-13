import javax.management.*;
import javax.security.auth.Subject;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

public class java_27598_SessionManager_A08 {
    private List<String> sessionList;
    private int currentIndex;

    public java_27598_SessionManager_A08(List<String> sessionList) {
        this.sessionList = sessionList;
        this.currentIndex = 0;
    }

    public String getNextSession() {
        if (currentIndex < sessionList.size()) {
            return sessionList.get(currentIndex++);
        }
        return null;
    }

    public void returnSession(String session) {
        if (sessionList.contains(session)) {
            int index = sessionList.indexOf(session);
            if (index == currentIndex) {
                currentIndex--;
            }
            sessionList.remove(session);
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager(List.of("Session1", "Session2", "Session3"));
        System.out.println(sessionManager.getNextSession()); // Session1
        System.out.println(sessionManager.getNextSession()); // Session2
        sessionManager.returnSession("Session1");
        System.out.println(sessionManager.getNextSession()); // Session3
        System.out.println(sessionManager.getNextSession()); // null
    }
}