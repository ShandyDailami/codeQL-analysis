import java.io.*;
import java.net.*;
import java.util.*;

class java_19275_SocketServer_A07 {
    private static final String AUTH_RESPONSE = "HTTP/1.1 401 Unauthorized\r\n" +
            "WWW-Authenticate: Basic realm=''\r\n\r\n";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);

                if (request.isEmpty() || request.startsWith("GET")) {
                    response = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html; charset=utf-8\r\n\r\n" +
                            "<h1>Hello, World!</h1>";
                    out.println(response);
                } else if (request.startsWith("AUTHENTICATE")) {
                    response = AUTH_RESPONSE;
                    out.println(response);
                } else {
                    response = "HTTP/1.1 401 Unauthorized\r\n" +
                            "WWW-Authenticate: Basic realm=''\r\n\r\n";
                    out.println(response);
                }
            }

            socket.close();
        }
    }
}