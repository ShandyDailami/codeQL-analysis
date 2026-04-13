import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03868_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client is connected");

                // Process the socket here
                // For example, start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error while listening for client connections");
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_03868_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, you can write the code to handle client communication
            // For example, read a message from the client, process it and send a response
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}