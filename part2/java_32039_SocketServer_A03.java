import java.net.*;
import javax.net.ssl.*;

public class java_32039_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a new SSLServerSocket with SSL enabled
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1010);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            // Write a request to the client
            clientSocket.getOutputStream().write("Hello Client, Welcome to Socket Server\n".getBytes());

            // Read a response from the client
            byte[] bytes = new byte[256];
            int byteCount = clientSocket.getInputStream().read(bytes);

            // Print the response
            String response = new String(bytes, 0, byteCount);
            System.out.println("Client Says: " + response);

            // Close the connection
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            serverSocket.close();
        }
    }
}