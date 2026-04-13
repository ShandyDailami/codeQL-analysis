import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33700_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_33700_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: handle client data security-sensitive operations, A08_IntegrityFailure
        // You can use your own implementation here

        // Close the socket
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}