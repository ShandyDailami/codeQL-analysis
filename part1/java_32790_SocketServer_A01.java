import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32790_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client connected");
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_32790_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        // Here you can implement the logic for handling the client
    }
}