import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03632_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Server setup
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            // Accept client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Setup I/O
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive and send messages
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, client!");
            }

            // Close connection
            socket.close();
        }
    }
}