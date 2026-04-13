import java.io.*;
import java.net.*;

public class java_15670_SocketServer_A08 {
    private static final String RECV_STRING = "received: ";
    private static final String CLIENT_STRING = "client: ";
    private static final String SERVER_STRING = "server: ";
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Waiting for client on port " + PORT + "...");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage, serverResponse;
            while ((clientMessage = dis.readUTF()) != null) {
                System.out.println(CLIENT_STRING + clientMessage);
                serverResponse = "Server says: " + clientMessage;
                dos.writeUTF(serverResponse);
                System.out.println(SERVER_STRING + serverResponse);
            }

            dos.close();
            dis.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}