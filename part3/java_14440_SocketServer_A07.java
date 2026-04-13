import java.net.ServerSocket;
import java.net.Socket;

public class java_14440_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Add authentication and authorization checks here
                // For simplicity, we'll just check if the connection is secure
                if (socket.getLocalSocketAddress().toString().matches(".*:8080.*/")) {
                    new Thread(new ClientHandler(socket)).start();
                } else {
                    System.out.println("Unauthorized connection from " + socket.getLocalSocketAddress());
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}