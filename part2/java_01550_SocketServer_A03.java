import java.io.*;
import java.net.*;

public class java_01550_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the client message
            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Create the malicious command "DROP TABLE Students"
            String command = "DROP TABLE Students";

            // Send the command to the client
            dos.writeUTF(command);

            socket.close();
        }
    }
}