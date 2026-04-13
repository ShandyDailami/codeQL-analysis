import javax.servlet.*;
import java.io.IOException;

public class java_39456_SessionManager_A08 implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the session manager if needed
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the session if available
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the request is a GET or POST request
        if (httpRequest.getMethod().equalsIgnoreCase("GET") || httpRequest.getMethod().equalsIgnoreCase("POST")) {
            // If the request is a GET or POST request and the session is not found, create a new session
            httpRequest.getSession();

            // If the session is not validated, redirect the user to a login page
            if (httpRequest.getSession().isNew()) {
                httpResponse.sendRedirect("/login.jsp");
            } else {
                // If the session is validated, proceed with the request
                chain.doFilter(request, response);
            }
        } else {
            // If the request is not a GET or POST request, send a 405 (Method Not Allowed) response
            httpResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }

    public void destroy() {
        // Clean up any resources used by the session manager
    }
}