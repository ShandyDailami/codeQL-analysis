import java.io.*;
import java.net.*;
import java.util.*;

public class java_29119_SocketServer_A07 {

    private static final String SERVER_MESSAGE = "Hello, client!";
    private static final String END_OF_LINE = "\n";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(SERVER_MESSAGE);

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Client said: " + clientMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}