import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_08230_SocketServer_A08 {

    public static void main(String[] args) {
        runServer();
    }

    public static void runServer() {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            int port = 12345;
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(port, null, InetAddress.getByName("localhost"));
            serverSocket.setSoTimeout(10000);
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;

            while (true) {
                SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
                clientSocket.setSoTimeout(10000);
                SecureRandom sr = new SecureRandom();
                sr.nextBytes(new byte[16]);
                clientSocket.setNeedClientAuth(true);
                clientSocket.setEnabledCipherSuites(sr.availableCipherSuites());
                clientSocket.setEnabledProtocols(sr.availableProtocols());

                // This is where the custom class for integrity failure is implemented
                CustomIntegrityFailure integrityFailure = new CustomIntegrityFailure();
                integrityFailure.handleIntegrityFailure(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}