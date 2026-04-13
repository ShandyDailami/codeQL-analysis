import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38287_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_38287_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement security measures for A01_BrokenAccessControl
        // For example, check if the client's IP address is whitelisted,
        // and handle connection exceptions appropriately

        try {
            // TODO: Implement other client-side operations here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}