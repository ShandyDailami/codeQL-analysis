import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01212_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = null;
        SSLServerSocket sslSocket = null;

        try {
            // Create a SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(1234);
            sslSocket.setNeedClientAuthentication(true);

            // Accept connection from the client
            Socket client = sslSocket.accept();
            System.out.println("Client connected!");

            // Get the input and output streams
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            // Send response
            output.write("Hello from Server!".getBytes());

            // Close the connection
            client.close();
        } finally {
            // Close the sockets
            if (sslSocket != null) {
                sslSocket.close();
            }
            if (socket != null) {
                socket.close();
            }
        }
    }
}