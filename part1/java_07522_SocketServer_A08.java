import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07522_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Create new threads for handling each client
                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_07522_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Here, you can implement your security-sensitive operations related to A08_IntegrityFailure.
            // For example, you can use SSL to secure the communication between the server and the client,
            // or use encryption algorithms to protect sensitive data.
            // However, this part is not included in the initial request.

            // After the operations are done, you can close the socket connection.
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}