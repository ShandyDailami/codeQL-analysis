import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_19404_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            SSLServerSocket serverSocket = null;
            // Create a SSLServerSocket
            serverSocket = (SSLServerSocket) new SSLServerSocket(54321);
            System.out.println("Waiting for client connection...");

            // Accept a new client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Get input and output streams from socket
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();
            sslSocket.setNeedClientAuth(true);

            DataInputStream input = new DataInputStream(sslSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(sslSocket.getOutputStream());

            // Start the connection process
            output.writeUTF("Connection established");

            // Close the input stream and output stream
            input.close();
            output.close();

            // Close the SSLServerSocket
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}