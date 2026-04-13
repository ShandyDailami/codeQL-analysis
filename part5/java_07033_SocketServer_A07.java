import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_07033_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());
    private static final String PASSWORD = "password"; // You should use a secure method to store the password. This is a simple example.

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            serverSocket.setNeedClientAuth(true);

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.startHandshake();

            // Authentication
            if (clientSocket.getSession() != SSLSession.SUCCESSFUL) {
                LOGGER.log(Level.SEVERE, "Authentication failed.");
                return;
            }

            // Encryption
            if (!PASSWORD.equals(new String(clientSocket.getCipherSuites()[0]))) {
                LOGGER.log(Level.SEVERE, "Incorrect cipher suite. Expected: Blowfish, Actual: " + clientSocket.getCipherSuites()[0]);
                return;
            }

            // Receive data
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while ((message = in.readLine()) != null) {
                LOGGER.info("Received: " + message);
                out.println("Received: " + message);
            }

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "I/O error.", ex);
        } catch (SSLException ex) {
            LOGGER.log(Level.SEVERE, "SSL error.", ex);
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}