import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_35404_SocketServer_A08 {

    public static void main(String[] args) throws Exception {

        SSLServerSocket serverSocket = null;
        SSLSocket clientSocket = null;

        try {
            // Create a SSL ServerSocket for accepting incoming connections.
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);

            // Accept a client connection
            clientSocket = (SSLSocket) serverSocket.accept();

            // Enable client's SSL.
            clientSocket.startHandshake();

            // Get a PrintWriter to send data back to the client.
            OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
            PrintWriter outToClient = new PrintWriter(out, true);

            // Get a reader to receive data from the client.
            InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader inFromClient = new BufferedReader(in);

            String clientMessage;
            while ((clientMessage = inFromClient.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Send a response back to the client.
                outToClient.println("Server says: " + clientMessage);
            }

        } finally {
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();
        }
    }
}