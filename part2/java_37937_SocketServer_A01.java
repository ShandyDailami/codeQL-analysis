import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37937_SocketServer_A01 {

    private static final int PORT = 12345; // Change this to your desired port

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Basic security: only allow access to the server from localhost
            if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                handleClient(socket);
            } else {
                System.out.println("Unauthorized connection from " + socket.getRemoteSocketAddress());
                socket.close();
           
            }
        }
    }

    private static void handleClient(Socket socket) {
        // TODO: Handle client request and response here
    }
}