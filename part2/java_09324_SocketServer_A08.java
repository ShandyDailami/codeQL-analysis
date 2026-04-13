import java.io.*;
import java.net.*;
import java.util.*;

public class java_09324_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("exit")) {
                break;
            }

            out.writeUTF("Thank you for connecting to " + clientSocket.getRemoteSocketAddress() + "\n");
            clientSocket.close();
        }

        serverSocket.close();
    }
}