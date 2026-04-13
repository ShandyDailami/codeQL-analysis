import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class java_22441_CredentialValidator_A03 implements Filter {

    private String expectedUsername;
    private String expectedPassword;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the expected username and password if they're provided
        this.expectedUsername = filterConfig.getInitParameter("expectedUsername");
        this.expectedPassword = filterConfig.getInitParameter("expectedPassword");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Validate the request
        String username = httpRequest.getParameter("username");
        String password = httpRequest.getParameter("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            // If either username or password is missing or empty, return a 401 Unauthorized response
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing username or password");
            return;
        }

        if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
            // If the username or password doesn't match the expected values, return a 403 Forbidden response
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid username or password");
            return;
        }

        // If everything is valid, continue with the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Clean up any resources that the filter might use
    }
}