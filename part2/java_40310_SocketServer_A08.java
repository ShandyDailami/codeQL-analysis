import java.io.*;
import java.net.*;

public class java_40310_SocketServer_A08 {
    private static final String CLIENT_MESSAGE = "Client message: %s\n";
    private static final String SERVER_MESSAGE = "Server message: %s\n";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.printf(CLIENT_MESSAGE, clientMessage);

            String serverMessage = "Hello, Client!";
            output.writeUTF(serverMessage);
            System.out.printf(SERVER_MESSAGE, serverMessage);

            clientSocket.close();
        }
    }
}