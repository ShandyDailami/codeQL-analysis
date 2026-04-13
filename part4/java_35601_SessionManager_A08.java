import javax.sql.SessionFactory;
import javax.sql.Session;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class java_35601_SessionManager_A08 extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        sessionFactory = (SessionFactory) getServletContext().getBean("sessionFactory");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String sessionId = request.getSession().getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Use session object for session-sensitive operations

        session.getTransaction().commit();
        session.close();

        response.setContentType("text/plain");
        response.getWriter().println("Session: " + sessionId);
    }
}