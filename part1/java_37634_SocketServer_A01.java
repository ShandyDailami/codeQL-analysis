import java.io.*;
import java.net.*;

public class java_37634_SocketServer_A01 {
    private static int serverPort = 12345;
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) throws Exception {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is listening on port " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Send the message to the client
                String message = "Hello, client!";
                output.writeUTF(message);

                // Receive the message from the client
                String response = input.readUTF();
                System.out.println("Received from client: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}