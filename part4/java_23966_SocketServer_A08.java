import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23966_SocketServer_A08 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();

            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Here, we're assuming the client is connecting to a well-known server.
            // For real-world applications, you'd want to establish secure communication
            // using SSL/TLS and handle authentication based on specific requirements.

            // Here, we're simply echoing back the client's data to the server.
            // In a real-world application, you'd want to handle the actual data received
            // and send a response back to the client.
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            socket.getOutputStream().write(bytes);
       
            socket.close();
        }
    }
}