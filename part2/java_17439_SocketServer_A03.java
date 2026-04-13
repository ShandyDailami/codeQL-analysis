import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17439_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Server port
        System.out.println("Server started. Waiting for client connection...");

        Socket socket = serverSocket.accept(); // Accept a client connection
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String input;
        while ((input = in.readLine()) != null) {
            System.out.println("Received client: " + input);
            out.println("Hello, client!");
        }

        socket.close();
    }
}