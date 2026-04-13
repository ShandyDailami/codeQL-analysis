import java.io.*;
import java.net.*;
import java.util.*;

public class java_25537_SocketServer_A03 {

    private static final String SERVER_STREAM_MSG = "Hello client, I am your secure server!";
    private static final int PORT = 12345;
    private static Socket socket;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client: " + message);

            out.writeUTF(SERVER_STREAM_MSG);
            System.out.println("Server: " + SERVER_STREAM_MSG);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}