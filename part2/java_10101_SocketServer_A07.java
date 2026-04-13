import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_10101_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());
    private static final String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER"; // You can change this.

    public static void main(String[] args) {
        int port = 12345; // You can change this.

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port)) {
            serverSocket.setNeedClientAuth(true);
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuth(true);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                logger.info("Received: " + inputLine);
                out.println("Hello, " + inputLine);
            }
        } catch (IOException e) {
            logger.severe("I/O exception occurred: " + e.getMessage());
        }
    }
}