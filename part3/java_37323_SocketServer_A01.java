import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37323_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Here, you should have a way of securing the connection to prevent unauthorized access
            // This is a simplistic example and a real-world application would require more robust security measures
            if (socket.getInputStream().read() != -1) {
                System.out.println("Unauthorized access detected!");
                socket.close();
            }
       
            // You could also implement a thread to handle multiple connections in a pool
            // However, this would complicate the code and make it harder to read and understand
        }
    }
}