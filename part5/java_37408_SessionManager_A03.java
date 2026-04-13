import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAware;

public class java_37408_SessionManager_A03 implements ServletRequestAware {

    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void startSession() {
        HttpSession session = request.getSession();
        session.setAttribute("user", "John Doe");
    }

    public String getSessionAttribute() {
        HttpSession session = request.getSession();
        return (String) session.getAttribute("user");
    }

    public void endSession() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}