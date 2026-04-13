import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class java_19337_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // Enable SSL
        sslServerSocket.setNeedClientAuthentication(true);

        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuthentication(true);

        // Create HTTP Servlet
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
                resp.setContentType("text/plain");
                PrintWriter writer = resp.getWriter();
                writer.println("Hello, SSL/TLS");
                writer.flush();
            }
        };

        // Start the servlet
        servlet.service(req, resp);

        // Close the SSL Socket
        sslSocket.close();
    }
}