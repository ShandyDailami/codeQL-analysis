import java.io.*;
import java.net.*;

public class java_37709_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(socket.getInputStream());

                String clientMessage = in.readUTF();
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello from server!";
                out.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}