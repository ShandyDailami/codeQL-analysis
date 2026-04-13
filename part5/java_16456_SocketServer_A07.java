import java.io.*;
import java.net.*;
import java.util.*;

public class java_16456_SocketServer_A07 {
    private static List<String> authorizedUsers = Arrays.asList("John", "Mary", "Steve");

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected.");

                DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

                String clientName = dataInputStream.readUTF();
                if (isClientAuthorized(clientName)) {
                    dataOutputStream.writeUTF("Connection established with " + clientName);
                } else {
                    dataOutputStream.writeUTF("Connection failed, please check your credentials");
                    clientSocket.close();
                    continue;
                }

                String message;
                while ((message = dataInputStream.readUTF()) != null) {
                    System.out.println("Received message: " + message);
                    dataOutputStream.writeUTF("Message received: " + message);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isClientAuthorized(String clientName) {
        return authorizedUsers.contains(clientName);
    }
}