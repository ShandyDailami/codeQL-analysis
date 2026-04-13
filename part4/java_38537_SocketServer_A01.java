import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38537_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Close the connection here if the client fails to authenticate
                // This is a simplistic example and in a real application, you would likely want to use a more secure method of authentication.
                if (!authenticate(clientSocket)) {
                    System.out.println("Client failed to authenticate, closing connection.");
                    clientSocket.close();
                    continue;
                }

                // Process the request here
                // In a real application, you would likely want to use a more secure method of communication.
                processRequest(clientSocket);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication here. This is a simplistic example and in a real application, you would likely want to use a more secure method of authentication.
        return true;
    }

    private static void processRequest(Socket socket) {
        // Implement request processing here. This is a simplistic example and in a real application, you would likely want to use a more secure method of communication.
    }
}