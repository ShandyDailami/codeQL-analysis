import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class java_31988_SocketServer_A03 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setEnabledCertificateOptions(SSLServerSocket.SELECT_DEFAULT);

            Socket socket = sslServerSocket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                logger.info("Received: " + message);
                out.println("Server says: " + message);
            }

            socket.close();

        } catch (IOException e) {
            logger.severe("I/O exception caught when trying to read from the socket.");
            e.printStackTrace();
        }
    }

}