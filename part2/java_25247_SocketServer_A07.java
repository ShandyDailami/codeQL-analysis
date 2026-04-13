import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_25247_SocketServer_A07 {

    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {

        // Create an SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(443);
        sslServerSocket.setNeedClientAuth(true);

        System.out.println("Waiting for client authentication...");

        SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
        clientSocket.startHandshake();

        // Perform server-side authentication
        if (clientSocket.getSession() != Session.SUCCESSFUL) {
            System.out.println("Authentication failed!");
            clientSocket.close();
            return;
        }

        System.out.println("Authentication successful!");

        // Now that we have a successful authentication, we can use the client socket
        // for communication.
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        // Send a message to the client
        out.writeUTF("Hello, Client!");
        out.flush();

        // Receive a message from the client
        String message = in.readUTF();
        System.out.println("Server received: " + message);

        // Close the socket
        clientSocket.close();
        sslServerSocket.close();
    }
}