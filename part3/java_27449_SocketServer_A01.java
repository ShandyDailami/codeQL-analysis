import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.ServerSocket;

public class java_27449_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(4444, null, null, null);
            System.out.println("Server started");

            while (true) {
                SSLSocket sslSocket = sslServerSocket.accept();
                System.out.println("Accepted a new connection from " + sslSocket.getRemoteSocketAddress());

                // Create input and output stream
                PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

                // Send a greeting message
                out.println("Hello Client, Welcome to Secure Socket Server");

                // Close the connection
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sslServerSocket.close();
        }
    }
}