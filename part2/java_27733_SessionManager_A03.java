import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SessionContext;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionManagerServlet")
public class java_27733_SessionManager_A03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public java_27733_SessionManager_A03() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String sessionId = request.getSession().getId();
        HttpSession httpSession = request.getSession(true);
        SessionContext sessionContext = request.getSession().getSessionContext();

        if(httpSession != null){
            response.getWriter().println("Session ID: " + httpSession.getId());
        }else{
            response.getWriter().println("Session ID: (null)");
        }

        if(sessionContext != null){
            response.getWriter().println("SessionContext ID: " + sessionContext.getId());
        }else{
            response.getWriter().println("SessionContext ID: (null)");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}