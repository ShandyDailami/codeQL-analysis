import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_29638_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        int port = 8081;

        // Start the server
        System.out.println("Server is starting...");
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message
            out.println("Welcome to the server");

            // Receive a message from the client and send a response
            String clientMessage = in.readLine();
            String response = "Server received: " + clientMessage;
            out.println(response);
        }
    }
}