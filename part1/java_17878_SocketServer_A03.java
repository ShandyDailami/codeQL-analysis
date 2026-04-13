import java.io.*;
import java.net.*;
import javax.servlet.*;
import org.apache.commons.lang3.StringUtils;

public class java_17878_SocketServer_A03 {
    private int port;

    public java_17878_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();

                // create input and output streams
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // handle HTTP request
                String request = reader.readLine();
                String response = processRequest(request);

                // send HTTP response
                writer.println(response);

                // close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // expected username and password
        String expectedUsername = "test";
        String expectedPassword = "test";

        // split request into username and password
        String[] parts = request.split(" ");
        String username = parts[1];
        String password = parts[2];

        // check if username and password match expected values
        if (StringUtils.equals(username, expectedUsername) && StringUtils.equals(password, expectedPassword)) {
            return "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html; charset=utf-8\r\n" +
                    "\r\n" +
                    "<html><body>Welcome, test!</body></html>";
        } else {
            return "HTTP/1.1 403 Forbidden\r\n" +
                    "Content-Type: text/html; charset=utf-8\r\n" +
                    "\r\n" +
                    "<html><body>Invalid credentials.</body></html>";
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}