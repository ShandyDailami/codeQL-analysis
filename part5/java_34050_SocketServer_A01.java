import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34050_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_34050_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can handle the client data.
        // This is just a placeholder and does not do anything
        // because the task is not really related to security.
    }
}