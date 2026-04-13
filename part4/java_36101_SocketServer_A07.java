import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36101_SocketServer_A07 {
    private static final int PORT = 1234; // chosen port
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT); // open server socket
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket client = server.accept(); // accept client connection
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

                // process the client connection here (for example, handle user input)
                // you can use a separate thread for each client for concurrent processing

                // in this example, we'll just close the connection and wait for the next client
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}