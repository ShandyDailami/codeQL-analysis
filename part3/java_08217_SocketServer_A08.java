import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_08217_SocketServer_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        // Setup SSL Server
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8080);
            serverSocket.setEnabledCipherSuites(new String[]{"TLSv1.2"});
            serverSocket.setNeedClientAuth(true);
            InetAddress address = InetAddress.getByName("127.0.0.1");
            serverSocket.bind(address);
            serverSocket.setReuseAddress(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Waiting for client on port 8080");
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Setup SSL Client
            SSLSocket sslSocket = (SSLSocket) clientSocket.getSocket();
            sslSocket.setEnabledCipherSuites(new String[]{"TLSv1.2"});
            sslSocket.setNeedClientAuth(true);

            // Write data to client
            sslSocket.write("Hello Client, I'm a Socket Server!!".getBytes());

            // Read data from client
            byte[] bytes = new byte[256];
            int bytesRead = sslSocket.read(bytes);
            System.out.println("Server says: " + new String(bytes, 0, bytesRead));

            sslSocket.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}