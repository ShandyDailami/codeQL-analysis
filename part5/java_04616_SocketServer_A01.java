import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_04616_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 443;
        String protocol = "TLSv1.2";
        
        // Create a server socket factory using the specified SSL context
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        
        // Create a new SSL Server Socket
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        
        // Bind the SSL server socket to a port
        sslServerSocket.bind(port);

        System.out.println("Server is running on port " + port);

        // Wait for a client to connect
        Socket clientSocket = sslServerSocket.accept();
        
        System.out.println("Client connected");

        // Get the input and output streams
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        // Read from the client
        byte[] buffer = new byte[1024];
        int bytesRead = input.read(buffer);
        String message = new String(buffer, 0, bytesRead);
        System.out.println("Received message: " + message);

        // Send a response back to the client
        String response = "Hello client, I received your message";
        output.write(response.getBytes());
        output.close();
        clientSocket.close();
        sslServerSocket.close();
    }
}