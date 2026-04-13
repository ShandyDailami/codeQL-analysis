import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_35294_SocketServer_A07 {
    private static final String SSL_PORT = "5000";

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException {
        SSLServerSocket sslServerSocket = null;
        SSLSocket sslSocket = null;
        ServerSocket serverSocket = null;

        try {
            // Load server's private key and certificate
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, null, null); // Add your key and cert

            // Create server socket
            serverSocket = new ServerSocket(Integer.parseInt(SSL_PORT));

            // Bind server socket to port and create SSL Server socket
            sslServerSocket = (SSLServerSocket) serverSocket.accept();
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setUseClientMode(true);

            sslSocket = (SSLSocket) sslServerSocket.accept();

            // Get input and output streams
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Send greeting message and receive welcome message
            String clientMessage = "Client Message";
            outputStream.write(clientMessage.getBytes());
            byte[] bytes = new byte[256];
            int byteRead = inputStream.read(bytes);
            String serverMessage = new String(bytes, 0, byteRead);

            System.out.println("Server received: " + serverMessage);
            System.out.println("Server sent: " + clientMessage);

            // Close the socket
            sslSocket.close();
            sslServerSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}