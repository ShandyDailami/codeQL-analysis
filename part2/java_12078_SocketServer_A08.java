import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_12078_SocketServer_A08 {

    public static void main(String[] args) {
        System.out.println("Starting server...");

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8080);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations
                try {
                    // ...

                } catch (CertificateException e) {
                    System.out.println("Certificate Exception occurred: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("I/O Exception occurred: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}