import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_40613_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    private final int port;

    public java_40613_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port, null, null, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuth(true);
            LOGGER.log(Level.INFO, "Secure Socket Server started at port: {0}", port);

            while (true) {
                final SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                LOGGER.log(Level.INFO, "Client accepted from: {0}", clientSocket.getRemoteSocketAddress());

                new Thread(() -> {
                    try (InputStream input = clientSocket.getInputStream();
                         OutputStream output = clientSocket.getOutputStream()) {

                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = input.read(buffer)) != -1) {
                            output.write(buffer, 0, length);
                        }
                    } catch (Exception e) {
                        LOGGER.log(Level.SEVERE, "Exception occurred while processing the client", e);
                    }
                }).start();
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred while starting the server", e);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Exception occurred while closing the server", e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8080).start();
    }
}