import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37346_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create SSL server socket
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket.setNeedClient(true);

            while (true) {
                // Wait for client connection
                clientSocket = (SSLSocket) serverSocket.accept();
                clientSocket.setNeedClient(true);

                // Handle client communication
                handleClient(clientSocket);

                // Close the client socket and server socket
                clientSocket.close();
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure all resources are closed
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static void handleClient(Socket socket) throws Exception {
        // Retrieve the input and output streams
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // Send response to client
        String response = "Hello, client!";
        output.write(response.getBytes());
        output.flush();

        // Read response from client
        byte[] buffer = new byte[256];
        int bytesRead = input.read(buffer);
        String received = new String(buffer, 0, bytesRead);

        // Print received message
        System.out.println("Received: " + received);
    }
}