import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class java_04387_SessionManager_A03 {

    private final SessionFactory sessionFactory;

    public java_04387_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void storeUserDataInSession(HttpServletRequest request, String userData) {
        HttpSession session = request.getSession();
        session.setAttribute("user", userData);
    }

    public Optional<String> retrieveUserDataFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return Optional.ofNullable((String) session.getAttribute("user"));
    }
}