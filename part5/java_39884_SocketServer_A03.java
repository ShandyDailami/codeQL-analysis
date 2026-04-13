import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_39884_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Set up SSL Server
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            socket = new ServerSocket(12345);
            sslSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, null);
            sslSocket.accept();

            // Accept client
            clientSocket = (SSLSocket) sslSocket.accept();
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Send response
            String response = "Hello, client!";
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(response);

            // Close
            writer.close();
            reader.close();
            clientSocket.close();
            sslSocket.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}