import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_00484_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("Starting SSL Server...");

        try (SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT)) {
            while (true) {
                try (SSLSocket socket = (SSLSocket) serverSocket.accept()) {
                    System.out.println("Client connected");

                    // Here goes your logic to process the client
                    // For simplicity, we'll echo back the message
                    String message = "Hello Client";
                    socket.getOutputStream().write(message.getBytes());

                    // Let's close the socket now
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}