import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23528_SocketServer_A08 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client has connected!");

                // Here you can place the code to handle the security-sensitive operations.
                // For instance, you can start a new thread to handle the client request.
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_23528_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Implement the security-sensitive operations here.
        // For instance, you can verify if the client is authenticated and has the necessary permissions.
        // You can then handle the client request.
    }
}