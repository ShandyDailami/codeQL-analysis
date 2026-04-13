import java.io.*;
import java.net.*;

public class java_15840_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello, client!";
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Client says: " + message);

                out.writeUTF(SERVER_MESSAGE);
                System.out.println("Server says: " + SERVER_MESSAGE);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}