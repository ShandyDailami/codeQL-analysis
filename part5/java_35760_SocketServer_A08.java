import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_35760_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        String message = "hello";
        int port = 8080;

        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                InetAddress ip = clientSocket.getInetAddress();

                logger.log(Level.INFO, "New connection from {0}", ip);

                // Read from the socket
                byte[] buffer = new byte[1024];
                int bytesRead = clientSocket.getInputStream().read(buffer);
                String response = new String(buffer, 0, bytesRead);

                // Send a response back to the client
                if (response.equals(message)) {
                    clientSocket.getOutputStream().write("Message received".getBytes());
                } else {
                    clientSocket.getOutputStream().write("Error: Incorrect message received".getBytes());
                }

                clientSocket.close();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception caught on server side", ex);
            System.exit(1);
        }
    }
}