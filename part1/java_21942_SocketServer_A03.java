import java.io.*;
import java.net.*;

public class java_21942_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port: " + server.getLocalPort() + "...");

        Socket client = server.accept();
        System.out.println("Connected to: " + client.getRemoteSocketAddress());

        DataOutputStream outToClient = new DataOutputStream(client.getOutputStream());
        DataInputStream inFromClient = new DataInputStream(client.getInputStream());

        String clientMessage, serverMessage;
        while(true) {
            clientMessage = inFromClient.readUTF();
            System.out.println("Received from client: " + clientMessage);

            serverMessage = "Hello, you sent: " + clientMessage;
            outToClient.writeUTF(serverMessage);
            System.out.println("Sent to client: " + serverMessage);
        }
    }
}