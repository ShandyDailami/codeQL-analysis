import java.io.*;
import java.net.*;

public class java_28291_SocketServer_A07 {

    private static final String AUTH_FAILURE_MESSAGE = "Authentication failure!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // Set your desired port here

        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("auth")) {
                out.writeUTF(AUTH_FAILURE_MESSAGE);
                out.flush();
            } else {
                out.writeUTF("Authentication successful!");
                out.flush();
            }

            clientSocket.close();
        }
    }
}