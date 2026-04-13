import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03154_SocketServer_A03 {

    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle client in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error creating server socket");
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_03154_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
    }
}