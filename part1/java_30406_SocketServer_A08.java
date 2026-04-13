import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

public class java_30406_SocketServer_A08 {

    public static void main(String[] args) throws IOException, CertificateException {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Set up the SSL server socket
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.loadKeyStore("/path/to/your/keystore.jks", "yourpassword".toCharArray());

            sslServerSocket = (SSLServerSocket) keyStore.getServerSocketFactory().createServerSocket(1234);
            sslServerSocket. setNeedClientAuth(true);

            // Set up the server socket
            serverSocket = (ServerSocket) keyStore.getSocketFactory().createServerSocket(1234);

            while (true) {
                // Wait for a client to connect
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                Socket socket = serverSocket.accept();

                // Send a message to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello client!");

                // Close the connection
                socket.close();
                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up
            if (serverSocket != null) serverSocket.close();
            if (sslServerSocket != null) sslServerSocket.close();
        }
    }
}