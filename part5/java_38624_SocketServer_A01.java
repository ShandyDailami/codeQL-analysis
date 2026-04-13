import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38624_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                // Handle client connection here
                // You can use multiple threads to handle multiple clients concurrently
                // new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Uncomment the below class if you want to handle client requests separately
    // private static class ClientHandler implements Runnable {
    //     private Socket socket;

    //     public java_38624_SocketServer_A01(Socket socket) {
    //         this.socket = socket;
    //     }

    //     @Override
    //     public void run() {
    //         // Handle client request here
    //         // For example, you can read the request from the client and send a response
    //     }
    // }
}