import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29149_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            // Setup SSL Server Socket
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(10001);
            serverSocket.setNeedClientAuth(true);

            // Accept client connection
            SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

            // Perform client authentication
            sslSocket.startHandshake();
            if (!sslSocket.getSession().isValid()) {
                throw new IOException("Could not validate the client");
            }
            System.out.println("Client is authenticated");

            // Socket Read and Write
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(sslSocket.getOutputStream());

            // Receive message from client
            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send back a message to client
            writer.write("Hello Client, You are connected to the server!".getBytes());
            writer.flush();

            sslSocket.close();
        } catch (SSLException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}