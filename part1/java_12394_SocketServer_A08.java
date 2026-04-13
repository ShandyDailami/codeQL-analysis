import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_12394_SocketServer_A08 {
    private static SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket)sslSocketFactory.createServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                System.out.println("Accepted a connection from: " + clientSocket.getRemoteSocketAddress());

                // Perform some SSL operations here
                // For example, perform a handshake
                clientSocket.startHandshake();
                System.out.println("Handshake completed");
                System.out.println("Client hello: " + clientSocket.getProtocolVersion());

                // Continue doing SSL operations here...

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}