import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31615_SocketServer_A03 {
    private static final int PORT = 6969;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");

                // Use a new thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_31615_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Create a new input stream to read the client's message
            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Read the client's message
            String message = reader.readLine();

            // Print the received message
            System.out.println("Received message: " + message);

            // Close the client's socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}