import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03066_SocketServer_A01 {
    private static final int PORT = 4444;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for connections on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the socket here, for example, by creating a new thread for each socket connection
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HandleClientThread extends Thread {
    private final Socket socket;

    public java_03066_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here, for example, by reading and writing data
        try {
            // Read data from the client
            byte[] bytes = new byte[100];
            socket.getInputStream().read(bytes);

            // Write data to the client
            socket.getOutputStream().write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}