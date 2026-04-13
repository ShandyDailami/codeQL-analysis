import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40612_SocketServer_A08 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Server started...");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here we use a simple integrity check for the integrity of the data sent from the client
                // In real-world applications, you should use a stronger mechanism for data integrity
                byte[] bytes = new byte[100];
                socket.getInputStream().read(bytes);

                // Here we simply convert the byte array to a string for simplicity
                String data = new String(bytes);
                System.out.println("Received data: " + data);

                // We respond back to the client with a simple message
                socket.getOutputStream().write("Hello, client!".getBytes());
           
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}