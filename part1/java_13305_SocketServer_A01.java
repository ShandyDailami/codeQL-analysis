import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13305_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket and wait for a client to connect
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        // Accept connection from client
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // Handle client communication
        handleClientCommunication(socket);

        // Close connection
        socket.close();
        serverSocket.close();
    }

    private static void handleClientCommunication(Socket socket) {
        // In a real-world application, this method would handle communication
        // with the client. Here, we are just echoing back the data received.

        // Create input and output streams
        try (Socket clientSocket = socket;
             java.io.BufferedReader in = new java.io.BufferedReader(
                     new java.io.InputStreamReader(socket.getInputStream()));
             java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}