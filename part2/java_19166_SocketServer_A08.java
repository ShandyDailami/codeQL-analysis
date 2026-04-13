import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_19166_SocketServer_A08 {
    private static final String SSL_PORT = "1234";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        serverSocket.setNeedClientAuthentication(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuthentication(true);

            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Read the client's message
            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Send a response back to the client
            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            out.flush();
        }
    }
}