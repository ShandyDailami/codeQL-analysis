import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34761_SocketServer_A07 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client connected " + socket.getInetAddress().getHostAddress());
                handleClient(socket);
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection " + e.getMessage());
       
        }
    }

    private static void handleClient(Socket socket) {
        // TODO: Implement secure operations for A07_AuthFailure
        // You can use SSL/TLS to encrypt the communication between client and server
        // You can use libraries such as Bouncy Castle or OpenSSL for this purpose

        // For now, let's just print a message to the console
        try {
            socket.getInputStream().read();
            System.out.println("Message from client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}