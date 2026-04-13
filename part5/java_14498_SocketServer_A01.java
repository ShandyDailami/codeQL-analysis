import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14498_SocketServer_A01 {
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here is where we start dealing with security sensitive operations
                // For example, we can encrypt the incoming data and send it to the client
                // However, this is a simple example and real-world usage would be more complex
                // and would involve secure communication channels (like SSL/TLS) and authentication
                // Plus, it would involve a lot more code to ensure the data is safe to send

                // For simplicity, we're just sending a random number back to the client
                socket.getOutputStream().write(socket.getLocalPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}