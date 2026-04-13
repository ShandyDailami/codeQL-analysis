import java.io.*;
import java.net.*;

public class java_16360_SocketServer_A03 {
    private static int DEFAULT_PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {
        System.out.println("Starting the Socket Server");
        startServer(DEFAULT_PORT);
    }

    public static void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Sending welcome message to client
                DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
                outToClient.writeUTF("Connected to the server");

                // Handling the client input and sending back the response
                DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
                System.out.println(inFromClient.readUTF());

                outToClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}