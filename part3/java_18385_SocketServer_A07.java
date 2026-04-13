import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_18385_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    private static final int PORT = 8888;

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            LOGGER.log(Level.INFO, "Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                LOGGER.log(Level.INFO, "Client connected");

                SSLSocket clientSSLSocket = (SSLSocket) clientSocket.createChannel(clientSocket.getInputStream(), clientSocket.getOutputStream());
                clientSSLSocket.setNeedClientAuth(true);

                SSLSession sslSession = clientSSLSocket.getSession();
                sslSession.setReadOnly();

                InputStream inputStream = clientSSLSocket.getInputStream();
                OutputStream outputStream = clientSSLSocket.getOutputStream();

                // Handle the SSLSocket here, e.g., process the request

                clientSSLSocket.close();
                LOGGER.log(Level.INFO, "Client disconnected");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error accepting client connection", ex);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Error closing serverSocket", ex);
            }
        }
    }
}