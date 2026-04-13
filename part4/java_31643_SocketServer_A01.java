import java.io.*;
import java.net.*;

public class java_31643_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");
        Socket client = server.accept();
        System.out.println("Connected to " + client.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message;
        while ((message = in.readUTF()) != null) {
            System.out.println("Received: " + message);
            switch (message) {
                case "exit":
                    System.out.println("Client has requested an exit");
                    out.writeUTF("exit");
                    break;
                case "shutdown":
                    System.out.println("Client has requested a shutdown");
                    out.writeUTF("shutdown");
                    break;
                default:
                    System.out.println("Unknown message from client");
                    out.writeUTF("unknown");
                    break;
            }
        }

        client.close();
        server.close();
    }
}