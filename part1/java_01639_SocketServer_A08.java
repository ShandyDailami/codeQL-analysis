import java.io.*;
import java.net.*;

public class java_01639_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive the message from the client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Check if the message is "exit" to close the connection
            if (message.equals("exit")) {
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " has disconnected!");
                output.writeUTF("You have disconnected!");
                socket.close();
                continue;
            }

            // Check if the client is authenticated. In this example, we just check if the message is "auth".
            if (message.equals("auth")) {
                output.writeUTF("Authentication successful!");
            } else {
                output.writeUTF("Invalid password!");
                continue;
            }

            // If everything is ok, send a success message to the client
            output.writeUTF("Message received!");
        }
    }
}