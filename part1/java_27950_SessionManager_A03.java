import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionContext;
import java.util.ArrayList;
import java.util.List;

public class java_27950_SessionManager_A03 implements HttpSessionListener, HttpSessionBindingListener, HttpSessionContext {
    private List<HttpSession> sessionList;

    public java_27950_SessionManager_A03() {
        sessionList = new ArrayList<>();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("isNew", true);
        sessionList.add(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().setAttribute("isNew", false);
        sessionList.add(se.getSession());
    }

    @Override
    public void valueBound(HttpSessionBindingEvent sbe) {
        // Do nothing
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent sbe) {
        // Do nothing
    }

    @Override
    public void sessionContextChanged(HttpSessionContext context) {
        // Do nothing
    }

    public int getActiveSessionCount() {
        int count = 0;
        for (HttpSession session : sessionList) {
            if (session.getAttribute("isNew") != null && (boolean) session.getAttribute("isNew")) {
                count++;
            }
        }
        return count;
    }
}