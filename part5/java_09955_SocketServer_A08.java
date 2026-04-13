import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09955_SocketServer_A08 {
    private static final int PORT = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for connections on port " + PORT + "...");

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());

            // Create stream for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Echo back any message received
            String message;
            while ((message = in.readLine()) != null) {
                out.println(message);
            }

            // Close the connection
            clientSocket.close();
        }
    }
}