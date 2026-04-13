import java.io.*;
import java.net.*;

public class java_35786_SocketServer_A08 {
    private static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running and waiting for client connections on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Handle the message here
            // For example, check for integrity failure
            if (message.contains("A08_IntegrityFailure")) {
                System.out.println("Integrity failure detected. Sending response...");
                output.writeUTF("Response: Integrity failure has been detected.");
            } else {
                System.out.println("No integrity failure detected. Sending response...");
                output.writeUTF("Response: No integrity failure detected.");
            }

            output.flush();
            clientSocket.close();
        }
    }
}