import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37420_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        // Create a SSL ServerSocket factory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Bind to port 8080 and enable SSL on it
        serverSocket = (ServerSocket) serverSocket.newServerSocket(8080);
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

        // SSL ServerSocket requires a keystore and a truststore
        sslServerSocket.setNeedClientAuthentication(true);

        // Create a new SSLSocket and bind it to the serverSocket
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
        sslSocket.setNeedClientAuthentication(true);

        // Set up streams
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);

        String inputLine;

        // Start the server
        while ((inputLine = in.readLine()) != null) {
            out.println("Server: " + inputLine);
        }

        sslSocket.close();
        serverSocket.close();
    }
}