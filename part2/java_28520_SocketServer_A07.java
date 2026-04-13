import java.net.*;
import java.io.*;

public class java_28520_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + 8189);

        Socket socket = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message;
        while ((message = in.readUTF()) != null) {
            System.out.println("Received: " + message);
            if (message.equals("exit")) {
                break;
            }
            out.writeUTF("Server received the message. Will now close the connection.");
        }

        socket.close();
        server.close();
    }
}