import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_25860_SocketServer_A03 {

    public static void main(String[] args) {
        boolean useSSL = true;
        int port = 8080;

        try {
            ServerSocket serverSocket;
            if (useSSL) {
                serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            } else {
                serverSocket = new ServerSocket(port);
           
            }
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                SSLSocket sslSocket = (SSLSocket) socket.getSocket();
                sslSocket.setNeedClientAuthentication(true);
                sslSocket.setEnabledProtocols(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
                System.out.println(sslSocket.getEnabledProtocols());
                sslSocket.startHandshake();
                System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected using protocol " + sslSocket.getProtocol() + " and cipher suite " + sslSocket.getEnabledCipherSuites() + " for client authentication");
                // Here is where we do something with the sslSocket, like read or write data
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}