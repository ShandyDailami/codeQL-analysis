import java.io.*;
import java.net.*;

public class java_34489_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 6789;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connected to client " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = "Hello client, your message was: " + message;
                out.writeUTF(response);
                System.out.println("Sent: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}