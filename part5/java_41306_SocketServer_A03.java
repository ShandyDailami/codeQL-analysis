import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41306_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error while setting up server: " + e.getMessage());
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_41306_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the socket
            // The socket can be used to send and receive messages
            // Here, we'll pretend we have received a message from the client
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Message received";
            socket.getOutputStream().writeUTF(response);
            socket.getOutputStream().flush();

            socket.close();

        } catch (IOException e) {
            System.out.println("Error while handling client: " + e.getMessage());
        }
    }
}