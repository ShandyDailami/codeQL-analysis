import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_01461_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Create SSLServerSocket and accept incoming connection
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080, null, null, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuth(true); // Enable client authentication

            System.out.println("Waiting for client authentication");

            // Accept incoming connection
            socket = (SSLSocket) serverSocket.accept();
            socket.startHandshake(); // Perform client authentication
            System.out.println("Client authenticated successfully");

            // Get input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Send message to client
            output.write("Hello client, Welcome to Socket Server\n".getBytes());

            // Close the connection
            socket.close();
            serverSocket.close();
        } finally {
            // Always close the socket
            if (socket != null) {
                socket.close();
            }
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}