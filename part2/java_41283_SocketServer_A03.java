import java.net.ServerSocket;
import java.net.Socket;

public class java_41283_SocketServer_A03 {
    // The port number on which the server will listen for connections.
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            // Create a new ServerSocket and listen for connections on this port.
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Start the server's loop for accepting incoming connections.
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Create a new Thread for handling the client's request
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        // Exceptions can be ignored here. The program will continue after
        // the server has been closed.
        }
    }
}

// This class handles the communication with a single client.
class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_41283_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Get a stream to read from the client.
            // We use a BufferedReader to get input from the client.
            // We use a PrintWriter to send data back to the client.
            // We use a DataInputStream to receive data from the client.
            // This code is using standard Java libraries.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            DataInputStream inStream = new DataInputStream(clientSocket.getInputStream());

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Here is where we perform injection prevention.
                // A real application might use a more sophisticated method
                // to prevent injection attacks. For this example, we'll just
                // sanitize the input string.
                message = sanitizeInput(message);

                out.println("Sanitized: " + message);
            }

            // Close the connection.
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is a simple implementation of input sanitization.
    // A real application might use a more sophisticated method
    // to prevent injection attacks.
    private String sanitizeInput(String input) {
        return input.replace("<", "&lt;").replace(">", "&gt;");
    }
}