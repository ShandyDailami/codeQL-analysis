import java.io.*;
import java.net.*;

public class java_05669_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Message received from client: " + message);

                // For simplicity, we'll just check if the message is empty and respond with a message.
                if ("".equals(message)) {
                    out.writeUTF("Server: Hello client, how are you today?");
                } else {
                    out.writeUTF("Server: No, I expected a empty message from you, didn't get it!");
                }
                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}