import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_40674_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Set up the server socket and accept incoming connections
        int port = 6789;
        Socket serverSocket = new Socket("localhost", port);
        System.out.println("Connected to port " + port);

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Continuously listen for client messages and send back to client
        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);
            out.println(clientMessage);
        }

        // Close the connection
        serverSocket.close();
    }
}