import java.io.*;
import java.net.*;
import java.util.*;

public class java_11475_SocketServer_A08 {
    private static final String SERVER_MESSAGE = "Hello Client, You are connected to the server!";
    private static int port = 8080;
    
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                out.writeUTF(SERVER_MESSAGE);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}