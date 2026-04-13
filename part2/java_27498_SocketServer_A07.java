import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_27498_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting server");

        // Create a SSLServerSocket for the server
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
        sslServerSocket.setEnabledCipherSuites(new String[]{"TLSv1.2"});
        sslServerSocket.setNeedClientAuth(true);

        // Accept a client connection
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

        // Get the remote address
        InetAddress remoteAddr = sslSocket.getRemoteSocketAddress();
        System.out.println("Connected to " + remoteAddr);

        // Send a response
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        out.println("Hello from Server");

        // Close the connection
        sslSocket.close();
   
        sslServerSocket.close();

        System.out.println("Connection closed");

    }
}