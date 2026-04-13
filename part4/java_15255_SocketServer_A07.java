import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.mindrot.jbcrypt.BCrypt;

public class java_15255_SocketServer_A07 {

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static DataInputStream inFromClient;
    private static DataOutputStream outToClient;

    private static final String SAFE_PASSWORD = "$2a$10$e$"; // This is a fixed string

    public static void main(String[] args) throws IOException {
        serverStart();
    }

    private static void serverStart() throws IOException {
        serverSocket = new ServerSocket(5000); // Set the server port
        System.out.println("Server started on port 5000");

        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            inFromClient = new DataInputStream(clientSocket.getInputStream());
            outToClient = new DataOutputStream(clientSocket.getOutputStream());

            handleClient(clientSocket);

            inFromClient.close();
            outToClient.close();
            clientSocket.close();
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        // Get the client's password
        String clientPassword = inFromClient.readUTF();

        // Hash the client's password
        String hashedPassword = BCrypt.hashpw(clientPassword, BCrypt.gensalt());

        // Check if the hashed password matches the safe password
        if (BCrypt.checkpw(clientPassword, SAFE_PASSWORD)) {
            // If the password matches, send a response
            outToClient.writeUTF("Access granted");
        } else {
            // If the password does not match, send an error response
            outToClient.writeUTF("Access denied");
        }
    }
}