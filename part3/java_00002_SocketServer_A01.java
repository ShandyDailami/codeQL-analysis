import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00002_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Simulate a security breach by creating a new thread for each client connection
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_00002_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Simulate a security breach by reading data from the socket
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            System.out.println("Received data: " + new String(buffer));

            // Respond to the client
            socket.getOutputStream().write("Hello Client".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}