import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_27359_SocketServer_A08 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        SSLServerSocket sslServerSocket = null;
        try {
            // Create a SSLServerSocket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
            sslServerSocket.setNeedClientAuth(true);

            // Accept a client connection
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            sslSocket.startHandshake();

            // Get input and output streams
            SSLInputStream sslIn = new SSLInputStream(sslSocket.getInputStream());
            SSLOutputStream sslOut = new SSLOutputStream(sslSocket.getOutputStream());

            // Read from the client
            byte[] bytes = new byte[1024];
            int bytesRead = sslIn.read(bytes);
            if (bytesRead < 0) {
                logger.info("Client disconnected");
                return;
            }

            // Check the integrity of data
            checkIntegrity(bytes, bytesRead);

            // Send a response back to the client
            sslOut.write("Hello, client!".getBytes());
            sslOut.flush();

            sslIn.close();
            sslOut.close();
            sslSocket.close();
            sslServerSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkIntegrity(byte[] bytes, int length) {
        byte[] expected = "Hello, client!".getBytes();
        if (length != expected.length) {
            logger.severe("Integrity check failed. Expected length: " + expected.length + ", but received: " + length);
        } else {
            for (int i = 0; i < length; i++) {
                if (bytes[i] != expected[i]) {
                    logger.severe("Integrity check failed. Byte mismatch at index: " + i);
                    return;
                }
            }
        }
    }

    // SSLInputStream and SSLOutputStream are used for SSL communication
    static class SSLInputStream extends InputStream {
        private InputStream innerStream;

        public java_27359_SocketServer_A08(InputStream stream) {
            this.innerStream = stream;
        }

        @Override
        public int read(byte[] b) throws IOException {
            return innerStream.read(b);
        }
    }

    static class SSLOutputStream extends OutputStream {
        private OutputStream innerStream;

        public java_27359_SocketServer_A08(OutputStream stream) {
            this.innerStream = stream;
        }

        @Override
        public void write(int b) throws IOException {
            innerStream.write(b);
        }
    }
}