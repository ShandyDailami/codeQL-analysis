import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Base64;

public class java_10072_SocketServer_A03 {

    private static final String AUTHENTICATED_USER = "user:password";

    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = null;

        // Start the server
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            try {
                // Wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Authenticate the client
                authenticateClient(socket);

                // Handle client requests
                handleRequests(socket);

            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }

    private static void authenticateClient(Socket socket) throws IOException {
        // Read the request from the client
        InputStream input = socket.getInputStream();

        // Read the request line and headers
        String requestLine = readRequestLine(input);
        System.out.println("Received: " + requestLine);

        // Parse the Authorization header
        String auth = parseAuthorizationHeader(requestLine);

        // Check the credentials
        if ("Basic " + base64Encode(AUTHENTICATED_USER)).equals(auth) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
            // Close the connection if authentication failed
            socket.close();
        }
    }

    private static void handleRequests(Socket socket) throws IOException {
        // Read the request from the client
        InputStream input = socket.getInputStream();

        // Read the request line and headers
        String requestLine = readRequestLine(input);
        System.out.println("Received: " + requestLine);

        // Read the whole request
        String request = readRequest(input);
        System.out.println("Received: " + request);

        // Send a response
        OutputStream output = socket.getOutputStream();
        String response = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain; charset=utf-8\r\n\r\n" +
                "Hello, World!";
        output.write(response.getBytes());
        output.flush();
        System.out.println("Sent: " + response);
    }

    private static String readRequestLine(InputStream input) throws IOException {
        StringBuilder builder = new StringBuilder();
        int c;

        while ((c = input.read()) != -1) {
            if (c == 10) { // end of request
                break;
            } else if (c == 13) { // start of headers
                break;
            } else {
                builder.append((char) c);
            }
        }

        return builder.toString();
    }

    private static String readRequest(InputStream input) throws IOException {
        StringBuilder builder = new StringBuilder();
        int c;

        while ((c = input.read()) != -1) {
            if (c == 10) { // end of request
                break;
            } else {
                builder.append((char) c);
            }
        }

        return builder.toString();
    }

    private static String base64Encode(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}