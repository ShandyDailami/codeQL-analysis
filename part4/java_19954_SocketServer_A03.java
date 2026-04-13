import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_19954_SocketServer_A03 {

    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(5000);
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                try {
                    InputStream inputStream = sslSocket.getInputStream();
                    OutputStream outputStream = sslSocket.getOutputStream();
                    // Read from the socket
                    byte[] buffer = new byte[1024];
                    int bytesRead = inputStream.read(buffer);
                    if (bytesRead < 0) {
                        LOGGER.log(Level.WARNING, "Client disconnected");
                        continue;
                    }
                    // Write back to the socket
                    outputStream.write(buffer, 0, bytesRead);
                    outputStream.flush();
                } finally {
                    sslSocket.close();
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "I/O Error", ex);
        } finally {
            if (sslServerSocket != null) {
                try {
                    sslServerSocket.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Error closing server socket", ex);
                }
            }
        }
    }
}