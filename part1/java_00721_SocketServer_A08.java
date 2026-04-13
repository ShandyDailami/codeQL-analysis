import java.io.*;
import java.net.*;

public class java_00721_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket client = server.accept();
        System.out.println("Connected to " + client.getRemoteSocketAddress());

        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        DataInputStream inputStream = new DataInputStream(client.getInputStream());

        String message;
        while ((message = inputStream.readUTF()) != null) {
            System.out.println("Received: " + message);

            if (message.equals("exit")) {
                System.out.println("Connection closed");
                break;
            }

            System.out.println("Sending: " + message);
            outputStream.writeUTF(message);
            outputStream.flush();
        }

        server.close();
        client.close();
    }
}