import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;

public class java_22163_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            // Load server certificate and private key
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(12345, null, InetAddress.getByName("localhost"));
            serverSocket.setNeedClientAuth(true); // Require client to present a certificate

            // Accept client connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Send response to client
            String response = "Hello, client!\n";
            byte[] bytes = response.getBytes();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}