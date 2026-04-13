import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/SessionManagerServlet")
public class java_37415_SessionManager_A07 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private DataSource dataSource;

    public void init() throws ServletException {
        try {
            dataSource = getServletContext().getNamedResource("jdbc/MyDS");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Implementation here
    }

    @Override
    public void destroy() {
        // Do nothing
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}