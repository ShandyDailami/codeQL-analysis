import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_37250_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Get InputStream and OutputStream from socket
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Process the inputStream and outputStream
            processRequest(inputStream, outputStream);

            // Close the socket connection
            socket.close();
        }
    }

    private static void processRequest(InputStream inputStream, OutputStream outputStream) throws IOException {
        // Read the request
        byte[] request = new byte[1024];
        int bytesRead = inputStream.read(request);

        // Process the request (e.g., log, sanitize, etc.)
        String sanitizedRequest = sanitizeRequest(new String(request, 0, bytesRead));

        // Write the response
        String response = "Response: " + sanitizedRequest;
        outputStream.write(response.getBytes());
    }

    private static String sanitizeRequest(String request) {
        // Add your security-sensitive operations here
        // For instance, remove any command injection attempts
        return request;
    }
}