import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class java_27412_SocketServer_A07 extends HttpServlet {

  private static final String AUTH_REQUIRED_PAGE = "auth_required.html";
  private static final String INDEX_PAGE = "index.html";

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>Welcome to our secure server!</h1>");
    out.println("</body></html>");
  }

  public static void main(String[] args) throws Exception {
    ServerSocket serverSocket = new ServerSocket(8080);
    System.out.println("Server is listening on port 8080");
    while (true) {
      Socket clientSocket = serverSocket.accept();
      System.out.println("Client accepted");
      new Thread(new SocketProcessor(clientSocket)).start();
    }
  }

  private static class SocketProcessor implements Runnable {
    private final Socket socket;

    public java_27412_SocketServer_A07(Socket socket) {
      this.socket = socket;
    }

    public void run() {
      try {
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String request = reader.readLine();
        System.out.println("Request: " + request);
        HttpServletRequest httpRequest = createHttpRequest(request);
        if (isAuthenticationRequired(httpRequest)) {
          PrintWriter writer = socket.getOutputStream().getWriter();
          writer.println("HTTP/1.1 401 Unauthorized");
          writer.flush();
          return;
        }
        processRequest(httpRequest);
      } catch (Exception e) {
        System.out.println("Error processing request: " + e);
      }
    }

    private boolean isAuthenticationRequired(HttpServletRequest request) {
      return !INDEX_PAGE.equals(request.getRequestURI());
    }

    private HttpServletRequest createHttpRequest(String request) {
      String[] requestLines = request.split("\n");
      HttpServletRequest httpRequest = new HttpservletRequest();
      for (String line : requestLines) {
        String[] pair = line.split(":", 2);
        if (pair.length == 2) {
          httpRequest.setRequestProperty(pair[0].trim(), pair[1].trim());
        }
      }
      return httpRequest;
    }

    private void processRequest(HttpServletRequest request) throws IOException {
      Servlet servlet = new HelloWorld();
      servlet.service(request, new HttpResponse(socket.getOutputStream()));
    }
  }
}