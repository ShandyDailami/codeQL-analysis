import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30011_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30011_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication
        // ...
    }
}