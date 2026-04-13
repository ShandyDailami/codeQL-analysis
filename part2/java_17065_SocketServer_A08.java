import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17065_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_17065_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can add code to handle the client, for instance, by reading and writing data
        // and possibly doing some security sensitive operations related to A08_IntegrityFailure.
        // For example, you can check if the client is authenticated and has permission to access the server
        // or if the data being sent from the client is encrypted.
    }
}