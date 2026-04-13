import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_07581_SocketServer_A08 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;

        try {
            // Create a SSL server socket
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT);
            serverSocket.setNeedClientAuth(true);

            // Accept a connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Get the input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Write a response to the client
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello, client!");

            // Close the socket
            clientSocket.close();
        } catch (SSLException e) {
            System.out.println("SSL exception occurred: " + e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}