import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_24150_SessionManager_A08 {

    private HttpServletRequest request;

    public java_24150_SessionManager_A08(HttpServletRequest request) {
        this.request = request;
    }

    public void setSessionAttribute(String name, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(name, value);
    }

    public Object getSessionAttribute(String name) {
        HttpSession session = request.getSession();
        return session.getAttribute(name);
    }

    public void invalidateSession() {
        HttpSession session = request.getSession();
        session.invalidate();
    }

}