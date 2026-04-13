import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_09114_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting SSL Server");

        // Create a SSL server socket
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8001);
        } catch (IOException e) {
            System.err.println("Failed to listen on port 8001");
            System.exit(-1);
        }

        // Accept connections
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Perform handshake to check the client's SSL version
                SSLSocket sslSocket = (SSLSocket) socket;
                sslSocket.handshake();

                // Output SSL version
                out.writeUTF("SSL version: " + sslSocket.getProtocol());
                out.flush();

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}