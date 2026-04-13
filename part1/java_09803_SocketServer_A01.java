import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_09803_SocketServer_A01 {
    private static SSLServerSocket serverSocket;
    private static SSLSocket clientSocket;
    private static BufferedReader inFromClient;
    private static PrintWriter outToClient;

    public static void main(String[] args) {
        try {
            // Create a SSLServerSocket
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            serverSocket.setNeedClientAuth(true);
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, new TrustManager[] { new TrustAllCerts() }, null);
            serverSocket.setSSLContext(context);
            // Accept client connection
            clientSocket = (SSLServerSocket) serverSocket.accept();
            // Set up input and output streams
            inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToClient = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handshake
            SSLHandshake sh = clientSocket.startHandshake();
            // Validate server certificate
            if (!sh.getSession().isValidate()) {
                System.out.println("Invalid certificate");
                System.exit(-1);
            }

            // Send response
            outToClient.println("Hello, client!");
            outToClient.flush();

            // Close connection
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}