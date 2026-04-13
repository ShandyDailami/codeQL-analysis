import java.io.*;
import java.net.*;

public class java_22227_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(12345); // default port
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");

            socket = serverSocket.accept(); // Waits for a client to connect
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // Send message back to client
            dataOutputStream.writeUTF("Server received your message: " + message);
            dataOutputStream.flush();

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}