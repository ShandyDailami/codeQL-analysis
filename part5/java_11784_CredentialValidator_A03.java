import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpActionListener;

public class java_11784_CredentialValidator_A03 implements Validator {

    private Map<String, String> credentials;

    public java_11784_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    @Override
    public void validate(HttpActionListener action) {
        HttpServletRequest request = (HttpServletRequest) action.getRequest();
        HttpServletResponse response = (HttpServletResponse) action.getResponse();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            session.setAttribute("loggedIn", true);
            response.sendRedirect("home.jsp"); // replace with the correct URL
        } else {
            response.sendRedirect("login.jsp"); // replace with the correct URL
        }
    }
}