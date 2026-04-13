import java.net.ServerSocket;
import java.net.Socket;

public class java_18033_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Here you can add security-sensitive operations like checking if the socket is still valid,
                // checking if the client has permission to connect, etc. This is just a placeholder and
                // real-world usage would require more complex security measures.

                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}