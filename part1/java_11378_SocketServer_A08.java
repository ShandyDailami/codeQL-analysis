import java.io.*;
import java.net.*;

public class java_11378_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create streams for receiving and sending data
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive the client's name and send a welcome message
                String clientName = in.readUTF();
                out.writeUTF("Hello, " + clientName + ". You are connected to the server.");

                // Receive file information and send the file content
                int filesize = in.readInt();
                byte[] file = new byte[filesize];
                in.readFully(file, 0, filesize);
                out.writeInt(file.length);
                out.writeBytes(file);

                // Close the streams
                out.close();
                in.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}