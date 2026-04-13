import java.io.*;
import java.net.*;
import java.util.*;

public class java_37909_SocketServer_A01 {
    private static final String DISCONNECT_MESSAGE = "Disconnected!";
    private static final String SERVER_MSG = "Hello client!";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started, waiting for connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = SERVER_MSG;
                dos.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}