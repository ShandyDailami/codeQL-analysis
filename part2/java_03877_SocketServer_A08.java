import java.io.*;
import java.net.*;

public class java_03877_SocketServer_A08 {
    private static String CLIENT_ADDRESS = "localhost";
    private static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client " + clientSocket.getRemoteSocketAddress() + " connected");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            output.writeUTF("Hello, Client, you sent: " + message);
            System.out.println("Sent: " + "Hello, Client, you sent: " + message);

            clientSocket.close();
        }
    }
}