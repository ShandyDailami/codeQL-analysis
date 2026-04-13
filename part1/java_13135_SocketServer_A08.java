import java.io.*;
import java.net.*;

public class java_13135_SocketServer_A08 {

    private static final String SERVER_STATUS = "Server running. Please send a message to the client.";
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                String serverMessage = "Server received your message: " + clientMessage;
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Sent message to client: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}