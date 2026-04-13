import java.io.*;
import java.net.*;
import java.util.*;

public class java_13933_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String clientMessage;
        while ((clientMessage = dataInputStream.readUTF()) != null) {
            System.out.println("Received: " + clientMessage);
            if (clientMessage.equalsIgnoreCase("exit")) {
                System.out.println("Client exited");
                break;
            }

            String serverResponse = "Server response: " + clientMessage;
            dataOutputStream.writeUTF(serverResponse);
            dataOutputStream.flush();
       
            System.out.println("Sent: " + serverResponse);
        }

        socket.close();
        serverSocket.close();
    }
}