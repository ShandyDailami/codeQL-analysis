import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_26060_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 8080;
        try {
            // Step 1: Start a new socket server
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running and waiting for connections on port " + port);

            while (true) {
                // Step 2: Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Step 3: Read the request from the client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = in.readLine();
                System.out.println("Received message: " + message);

                // Step 4: Process the request (in this case, simply echo the message back to the client)
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Server: " + message);

                // Step 5: Close the connections
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}