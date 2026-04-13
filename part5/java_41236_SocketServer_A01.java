import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41236_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {

        // Step 1: Create a new ServerSocket on the specified port.
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        // Step 2: Wait for a client to connect.
        Socket socket = serverSocket.accept();
        System.out.println("Client has connected!");

        // Step 3: Handle the communication from the client.
        // Here you would typically have a loop waiting for incoming data,
        // handle it and then send a response back to the client.
        // This is a minimalist style example, you would typically use a BufferedReader
        // and BufferedWriter for efficient I/O.
        // Here, I'll just use a simple String to mimic this.

        // Assume the client says something, then send it back
        String clientMessage = "Server says: Hello, Client!";
        socket.getOutputStream().write(clientMessage.getBytes());

        // Close the connection.
        socket.close();
        serverSocket.close();
    }
}