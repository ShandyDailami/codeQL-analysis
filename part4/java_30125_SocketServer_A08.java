import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30125_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle the socket here. For example, you can start a new thread for each client
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_30125_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle the socket here
    }
}