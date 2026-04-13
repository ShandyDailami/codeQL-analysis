import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class java_40490_SessionManager_A08 {

    private static final String LOGIN_PAGE = "/WEB-INF/views/login.jsp";
    private static final String INITIAL_PAGE = "/WEB-INF/views/initial.jsp";

    public static void checkAuthentication(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user == null) {
            try {
                response.sendRedirect(request.getContextPath() + LOGIN_PAGE);
            } catch (Exception e) {
                System.out.println("Error while redirecting to login page: " + e.getMessage());
            }
        }
    }

    public static void checkAuthorization(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String user = (String) session.getAttribute("user");
        if (user != null && !user.equals("admin")) {
            try {
                response.sendRedirect(request.getContextPath() + INITIAL_PAGE);
            } catch (Exception e) {
                System.out.println("Error while redirecting to initial page: " + e.getMessage());
            }
        }
    }

}