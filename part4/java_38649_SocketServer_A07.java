import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_38649_SocketServer_A07 {

    private static Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            // Create an SSL ServerSocket with the port number provided.
            serverSocket = (SSLServerSocket) new SSLServerSocket(54321);
            logger.info("Server started on port 54321");
            while (true) {
                SSLSocket sock = (SSLSocket) serverSocket.accept();
                InputStream in = sock.getInputStream();
                OutputStream out = sock.getOutputStream();

                // Handshake
                SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
                sock = (SSLSocket) sslSocketFactory.createSocket(sock, serverSocket.getInetAddress(), 0, false);

                sock.startHandshake();

                // Communication
                while ((in.read()) != -1) {
                    int data = in.read();
                    logger.info("Received: " + data);
                    out.write(data);
                    out.flush();
                }
                sock.close();
            }
        } catch (IOException e) {
            logger.severe("Server Failed to start: " + e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    logger.severe("Error while closing the serverSocket: " + e.getMessage());
                }
            }
        }
    }
}