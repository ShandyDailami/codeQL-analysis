import java.io.*;
import java.net.*;
import java.util.*;

public class java_36197_SocketServer_A01 {
    private static final String RESPONSE_HEADER = "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/plain; charset=UTF-8\r\n" +
            "Content-Length: 2\r\n" +
            "\r\n" +
            "OK";

    private static final String BAD_REQUEST = "BAD REQUEST";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readLine();
            System.out.println("Request: " + request);

            String response = handleRequest(request);

            out.writeBytes(RESPONSE_HEADER + "\r\n\r\n" + response);
            out.flush();
            clientSocket.close();
        }
    }

    private static String handleRequest(String request) {
        // This is a simple example of handling a request. In a real-world application,
        // you would probably want to use a library like Apache HttpClient to handle
        // more complex requests. However, for simplicity, we will just return the same
        // response for all requests.
        if (request.equals("")) {
            return BAD_REQUEST;
        } else {
            return "OK";
        }
    }
}