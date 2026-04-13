import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09341_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Here you can add your security-sensitive operations like username/password authentication,
                // SSL encryption, etc. For the sake of simplicity, let's just print a welcome message.
                printWelcomeMessage(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Error during server initialization: " + e.getMessage());
        }
    }

    private static void printWelcomeMessage(Socket socket) {
        try {
            // Here we assume that the message is a simple string, but in a real-world scenario, it might be a complex object
            String message = "Welcome to the server! Have a great day!";
            socket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            System.out.println("Error while sending welcome message: " + e.getMessage());
        }
    }
}