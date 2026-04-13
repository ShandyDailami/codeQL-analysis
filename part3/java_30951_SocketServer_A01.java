import java.net.ServerSocket;
import java.net.Socket;

public class java_30951_SocketServer_A01 {
    private static final String PASSWORD = "securePassword"; // Password for authentication

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Binding to port 8080
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client is connected");

                // Authentication
                String clientPassword = socket.getInputStream().readUTF(); // Reading password from client
                if (PASSWORD.equals(clientPassword)) {
                    System.out.println("Authentication successful");
                    handleClient(socket); // Handling the client
                } else {
                    System.out.println("Authentication failed");
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client here, for example:
        // - Sending a response
        // - Receiving and sending data
    }
}