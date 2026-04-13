import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21044_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected!");

            // Perform operations related to A03_Injection here.
            // In this example, we just echo the message back to the client
            performOperations(clientSocket);
       
        }
    }

    private static void performOperations(Socket socket) {
        try {
            // Read from the client
            // In this example, we are only echoing back the message
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = reader.readLine();
            System.out.println("Received message from client: " + clientMessage);

            // Send response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server: Message received");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}