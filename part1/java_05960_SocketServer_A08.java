import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05960_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());
                // Start a new thread to handle the new connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to setup server socket");
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Failed to close the server socket");
                }
            }
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_05960_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the client connection and data here
        // For now, we'll just print a message
        System.out.println("Handling client: " + socket.getRemoteSocketAddress());
    }
}