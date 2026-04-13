import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31912_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_31912_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create a new input stream and output stream
            // Read from the socket, write to the socket
            // Handle exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}