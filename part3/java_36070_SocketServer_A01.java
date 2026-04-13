import java.io.*;
import java.net.*;

public class java_36070_SocketServer_A01 {
    private static int PORT = 1234;
    private static String SEND_MESSAGE = "Hello from server!";

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Waiting for a client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            // Reading message from client
            String message = in.readUTF();
            System.out.println("Message received by client: " + message);

            // Sending message to client
            out.writeUTF(SEND_MESSAGE);
            System.out.println("Message sent to client");

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}