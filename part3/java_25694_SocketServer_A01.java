import java.net.*;
import java.io.*;

public class java_25694_SocketServer_A01 {
    private static int serverPort = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started at port: " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                String response = "Server received your message: " + message;
                out.writeUTF(response);
                System.out.println("Sent message: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}