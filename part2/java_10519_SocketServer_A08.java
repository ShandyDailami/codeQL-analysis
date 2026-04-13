import java.io.*;
import java.net.*;

public class java_10519_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientName = in.readUTF();
            System.out.println("Received client name: " + clientName);

            String response = "";
            for (char c : clientName.toCharArray()) {
                response += (char) (c ^ 0x20);  // XOR with 0x20
            }

            out.writeUTF(response);
            out.flush();
        }
    }
}