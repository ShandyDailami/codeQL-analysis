import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04125_SocketServer_A03 {
    private static final int PORT = 6666;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started, waiting for connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client connection here using separate thread
                new HandleClient(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_04125_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here using separate thread
    }
}