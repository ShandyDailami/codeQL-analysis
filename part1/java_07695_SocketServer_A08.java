import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07695_SocketServer_A08 {

    private static final String SERVER_KEY = "secret";

    public static void main(String[] args) throws IOException {
        // Create a server socket and bind it to a port
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();

            // Get the input stream from the client
            java.io.InputStream input = socket.getInputStream();

            // Read the client's HTTP request
            byte[] bytes = new byte[1024];
            int length = input.read(bytes);
            String request = new String(bytes, 0, length);

            // Extract the username from the request
            String[] parts = request.split(" ");
            String username = parts[1];

            // Check if the username is correct
            if ("username=".concat(username)).equals(request) {
                // If the username is correct, send a response
                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Access-Control-Allow-Origin: *\r\n" +
                        "\r\n" +
                        "<h1>Welcome, " + username + "!</h1>";

                socket.getOutputStream().write(response.getBytes());
            } else {
                // If the username is incorrect, send a 401 response
                String response = "HTTP/1.1 401 Unauthorized\r\n" +
                        "WWW-Authenticate: Basic realm=\"Secret Area\"\r\n" +
                        "\r\n";

                socket.getOutputStream().write(response.getBytes());
            }

            // Close the socket
            socket.close();
        }
    }
}