import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36179_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Here you can handle the socket and perform security-sensitive operations.
                // For example, you can limit the socket to only send and receive data up to 1024 bytes.

                // You can also use a SecureSocket for the socket, but be aware that the SecureSocket is deprecated
                // and it's recommended to use SSL/TLS for secure communication.

                // Example:
                // SecureSocket securesocket = new SecureSocket(socket);
                // securesocket.setReceiveBufferSize(1024);
                // securesocket.setSendBufferSize(1024);

                // Here you can write the code to handle the socket in a secure way.

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}