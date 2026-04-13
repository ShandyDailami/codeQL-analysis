import java.io.*;
import java.net.*;

public class java_29797_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for client...");

            Socket socket = server.accept();

            System.out.println("Connection established with " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage;

            // Reading client message
            clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Sending response to client
            out.writeUTF("Hello, client, thank you for connecting!");
            out.flush();

            socket.close();
            server.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}