import java.io.*;
import java.net.*;

public class java_18608_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);

        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Thank you for connecting";
            out.writeUTF(serverMessage);

            socket.close();
        }
    }
}