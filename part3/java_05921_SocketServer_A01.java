import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05921_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server started on port 8000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while starting the server: " + e.getMessage());
       
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_05921_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Access control: The client does not request a file but accesses a sensitive data.
            // This is an example of a security-sensitive operation, hence A01_BrokenAccessControl.
            socket.getInputStream().read();
            System.out.println("Client accessed sensitive data!");

            // Send response back to the client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        }
    }
}