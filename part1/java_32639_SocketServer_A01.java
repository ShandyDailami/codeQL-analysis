import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32639_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + "...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Slightly more secure way of handling the socket connection
                new SecureServerHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class SecureServerHandler extends Thread {

    private final Socket socket;

    public java_32639_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can add your security-sensitive operations
    }
}