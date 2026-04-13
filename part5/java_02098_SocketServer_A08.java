import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02098_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());
                new SocketServerThread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
       
        }
    }
}

class SocketServerThread extends Thread {

    private final Socket socket;

    public java_02098_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // For now, just print out the socket address
        try {
            System.out.println(socket.getInetAddress().getHostAddress() + " wrote: " + socket.getInputStream().read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}