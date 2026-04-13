import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28286_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create an SSLServerSocket with a truststore and a keystore
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, null, null, null);

            // Set up an SSLSocket for accepting client connections
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            // Set up a buffered reader and writer
            SSLInput in = new SSLInput(sslSocket.getInputStream());
            SSLOutput out = new SSLOutput(sslSocket.getOutputStream());

            // Send a greeting message
            out.println("Welcome to the Socket Server!");

            // Read and print the client's message
            System.out.println("Client says: " + in.readLine());

            // Close the connection
            sslSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }
}