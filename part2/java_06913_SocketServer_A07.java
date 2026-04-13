import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_06913_SocketServer_A07 {
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            int port = 443;
            ServerSocket socket = (port < 1024) ? (ServerSocket) new SSLServerSocket(port) : (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            socket.setReuseAddress(true);
            while (true) {
                Socket clientSocket = socket.accept();
                InetAddress clientAddress = clientSocket.getInetAddress();
                LOGGER.log(Level.INFO, "Accepted connection from " + clientAddress);
                new EchoHandler(clientSocket).start();
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Exception caught on server-side", ex);
            System.exit(1);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Exception caught on client-side", ex);
        }
    }
}

class EchoHandler extends Thread {
    private final Socket socket;

    public java_06913_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // InputStreamReader isRead = new InputStreamReader(socket.getInputStream());
            // BufferedReader in = new BufferedReader(isRead);
            // PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // String message;
            // while ((message = in.readLine()) != null) {
            //     out.println(message);
            // }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Exception caught in EchoHandler", ex);
        }
    }
}