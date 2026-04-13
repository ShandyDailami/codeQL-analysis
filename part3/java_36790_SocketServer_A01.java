import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36790_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080; // the port to listen to
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept(); // waits for a client to connect
                System.out.println("A client has connected");

                // Handling communication with the client
                new ClientHandler(socket).start(); // start the thread for communication with the client
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_36790_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // read incoming message from the client
            // for simplicity, we just read the first line of the message
            String message = socket.getInputStream().readUTF();
            System.out.println("Received message: " + message);

            // write outgoing message to the client
            socket.getOutputStream().writeUTF("Server received your message");
            socket.getOutputStream().flush();

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}