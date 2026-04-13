import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37294_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected");

                // Handle the client in a new thread
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Here, you would handle the client's request
        // However, for the sake of this example, we'll just send a simple message back
        try {
            socket.getOutputStream().write("Hello client, you've connected!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}