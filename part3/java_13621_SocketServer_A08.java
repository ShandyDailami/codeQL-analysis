import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13621_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Handling the connection in a separate thread
                Thread thread = new Thread(new SocketHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_13621_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations related to A08_IntegrityFailure
            // For example, checking if the socket is valid and if it's already closed
            if (socket.isValid() && !socket.isClosed()) {
                // TODO: Perform operations on the socket here
            } else {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}