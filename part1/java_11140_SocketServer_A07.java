import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_11140_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        // Load the server's certificate and key
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(5000, null, null, SSLServerSocket.getSupportedSSLProtocols());

        // Accept connections
        SSLSocket socket = (SSLSocket) serverSocket.accept();

        // Create reader and writer
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send a welcome message
        out.println("Welcome to the server!");

        String message;
        while ((message = in.readLine()) != null) {
            // Echo back the message
            out.println(message);
       
            // Echo back the message length
            out.println(message.length());
        }

        socket.close();
    }
}