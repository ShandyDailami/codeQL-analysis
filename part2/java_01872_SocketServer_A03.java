import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01872_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_01872_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the message from the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Send a response back to the client
                out.println("Server response: " + message);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }
}