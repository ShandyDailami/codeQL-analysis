import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30882_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected");
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error establishing server socket: " + e.getMessage());
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30882_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read from the client
            // Implementation of the code here
            // ...

            // Write to the client
            // Implementation of the code here
            // ...

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}