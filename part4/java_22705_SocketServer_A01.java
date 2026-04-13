import java.io.*;
import java.net.*;

public class java_22705_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a welcome message
                out.println("Welcome to the server!");

                // Read the client's message and echo it back
                String clientMessage = in.readLine();
                out.println("Server received: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}