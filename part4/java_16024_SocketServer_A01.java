import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16024_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");

                // Here, you can use a ThreadPoolExecutor for handling multiple client connections
                // and use SSL or other security measures for better protection

                new Handler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_16024_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can implement a protocol for communication between server and client
        // For instance, you can use BufferedReader and BufferedWriter for reading and writing
        // and use SSL for secure communication
    }
}