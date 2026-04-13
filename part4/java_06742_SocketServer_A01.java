import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06742_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted from: " + socket.getRemoteSocketAddress());

            // Perform security-sensitive operations here

            // Echo the message back to the client
            String message = "Message received: " + socket.getInputStream().read();
            socket.getOutputStream().write(message.getBytes());
            socket.getOutputStream().flush();
       
            System.out.println("Message sent: " + message);
        }
    }
}