import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16526_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_16526_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            socket.receive(null);

            // Send a response to the client
            socket.send(("Hello, client!").getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}