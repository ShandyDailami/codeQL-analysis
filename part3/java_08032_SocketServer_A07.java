import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_08032_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        try {
            // Create a SSLServerSocket with the specified port
            serverSocket = (SSLServerSocket) new SSLServerSocket(4444);
            serverSocket.setNeedClientAuthentication(true);

            // Accept a new connection
            socket = (SSLSocket) serverSocket.accept();
            socket.setNeedClientAuthentication(true);

            // Send a welcome message to the client
            OutputStream out = socket.getOutputStream();
            DataOutputStream outToClient = new DataOutputStream(out);
            outToClient.writeUTF("Connection established!");

            // Read a message from the client
            DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
            System.out.println("Message from client: " + inFromClient.readUTF());

            // Close the connection
            socket.close();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}