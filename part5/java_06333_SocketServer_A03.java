import java.io.*;
import java.net.*;
import java.util.*;

public class java_06333_SocketServer_A03 {
    private static final String SERVER_NAME = "Secure Server";
    private static final int SERVER_PORT = 55555;
    private static final String CLIENT_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(SERVER_NAME, SERVER_PORT));

            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from: " + clientSocket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = input.readUTF();
                System.out.println("Received: " + clientMessage);

                String serverMessage = "Server: " + clientMessage;
                output.writeUTF(serverMessage);
                output.flush();

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}