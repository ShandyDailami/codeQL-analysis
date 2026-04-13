import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_34696_SocketServer_A07 {
    private final static int PORT = 1234;

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            // Setup server socket
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Wait for client to connect
            socket = server.accept();
            System.out.println("Client connected");

            // Get input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Handle the client's request
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead < 0) {
                System.out.println("Error reading from client");
                return;
            }

            // Authentication is sensitive, so we should handle it here
            String request = new String(buffer, 0, bytesRead);
            if ("A07_AuthFailure".equals(request)) {
                System.out.println("Auth Failure, closing connection");
                socket.close();
            } else {
                // If authentication is successful, send a response
                output.write("Success".getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the socket and server
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}