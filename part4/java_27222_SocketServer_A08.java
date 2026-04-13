import java.io.*;
import java.net.*;

public class java_27222_SocketServer_A08 {
    private static final String SERVER_NAME = "Secure Socket Server";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Perform security-sensitive operations related to A08_IntegrityFailure

                // Example: Read and echo the client's message
                String clientMessage = input.readUTF();
                output.writeUTF("Server: " + clientMessage);
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}