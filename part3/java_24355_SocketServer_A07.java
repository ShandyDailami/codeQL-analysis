import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_24355_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("localhost");

            // Create a SSLServerSocket using a custom SSLServerSocketFactory
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 10000, address, null);

            // Set the SSL socket to accept only connections from the specific IP address
            sslServerSocket.setNeedClientAuth(true);
            sslServerSocket.setRiskAcceptingConnections(true);

            // Bind the socket to the specific IP address
            sslServerSocket.bind(address, 8080);

            while (true) {
                Socket socket = sslServerSocket.accept();
                new SSLHandler(socket).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SSLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}