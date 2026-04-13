import java.io.*;
import java.net.*;

public class java_30978_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Server says: Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}