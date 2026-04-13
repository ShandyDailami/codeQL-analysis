import java.io.*;
import java.net.*;

public class java_27286_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Connected with the client!");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message from client: " + message);

            out.writeUTF("Server received your message successfully");
            out.flush();

            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}