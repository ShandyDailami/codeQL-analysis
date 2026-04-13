import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26702_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A client has connected!");

                // Handle the client connection and data
                new Thread(new SocketHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;

    public java_26702_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client
            // ...

            // Write response to the client
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}