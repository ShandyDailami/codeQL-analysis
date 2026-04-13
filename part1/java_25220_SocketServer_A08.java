import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25220_SocketServer_A08 {

    private static final int DEFAULT_PORT = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        openServerSocket(DEFAULT_PORT);
        handleClients();
    }

    private static void openServerSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to open port " + port);
            System.exit(-1);
        }
    }

    private static void handleClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error handling client");
                System.exit(-1);
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client here, for now let's just close the connection
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}