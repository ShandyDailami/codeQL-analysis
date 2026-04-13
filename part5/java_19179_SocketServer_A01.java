import java.io.*;
import java.net.*;
import java.util.*;

public class java_19179_SocketServer_A01 {

    private static final String HTTP_RESPONSE_TEMPLATE = "HTTP/1.1 %s\r\n" +
                                                         "Server: JavaServer/1.0\r\n" +
                                                         "Content-type: text/html\r\n" +
                                                         "\r\n" +
                                                         "%s" +
                                                         "\r\n";

    private static final String CRLF = "\r\n";

    private ServerSocket serverSocket;

    public java_19179_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server is running on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String requestLine = in.readLine();
                System.out.println("Received request: " + requestLine);

                String response = "Hello, you made a request!";
                out.printf(HTTP_RESPONSE_TEMPLATE, "200 OK", response);
                out.println(CRLF);

                out.flush();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error occurred while processing the client: " + e);
                e.printStackTrace();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer(8080).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}