import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05622_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        // Keep listening for connections
        while (true) {
            // Accept a new client connection
            Socket socket = serverSocket.accept();

            // Create a new thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_05622_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Create a new InputStream and BufferedReader for reading data from the client
        try (socket.getInputStream())) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read a line of data from the client
            String message = reader.readLine();

            // Process the message
            System.out.println("Received message: " + message);

            // Send a response back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Server received your message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}