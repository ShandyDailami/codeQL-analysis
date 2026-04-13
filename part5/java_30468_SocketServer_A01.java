import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_30468_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create an SSLServerSocket and bind it to port 1234
            SSLServerSocket server = (SSLServerSocket) new SSLServerSocket(1234);
            server.setNeedClientAuth(true);

            // Accept client connection
            System.out.println("Waiting for client connection ...");
            clientSocket = (SSLSocket) server.accept();
            System.out.println("Client connected!");

            // Create Input and Output Streams
            OutputStream outToClient = clientSocket.getOutputStream();
            InputStream inFromClient = clientSocket.getInputStream();

            // Read request from client
            DataInputStream in = new DataInputStream(inFromClient);
            DataOutputStream out = new DataOutputStream(outToClient);

            // Write response to client
            out.writeUTF("Hello client, you are connected to the secure server!");
            out.flush();

            // Close connection
            clientSocket.close();
        } finally {
            // Close server connection
            serverSocket.close();
        }
    }
}