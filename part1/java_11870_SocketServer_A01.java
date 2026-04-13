import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11870_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected!");

                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            // Here you can include the code to authenticate the client.
            // This is a very basic example and does not include secure methods.
            // For real security, you should use SSL/TLS for secure communication.
            String clientAddress = clientSocket.getInetAddress().getHostAddress();
            System.out.println("Client " + clientAddress + " has authenticated!");

            // Now, the client can send and receive data

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}