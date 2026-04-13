import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14334_SocketServer_A08 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                // Process the client connection
                ClientHandler handler = new ClientHandler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting the server.");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_14334_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the client's message
            // Assume the client's message is a string
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Process the message (e.g., check for integrity failure)
            // Assume the process is to change the message to uppercase
            message = message.toUpperCase();

            // Send the processed message back to the client
            socket.getOutputStream().writeUTF(message);
            socket.getOutputStream().flush();

        } catch (IOException e) {
            System.out.println("Error occurred while processing the client.");
            e.printStackTrace();
        }
    }
}