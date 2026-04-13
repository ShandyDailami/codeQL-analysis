import java.io.*;
import java.net.*;

public class java_08598_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started at port 8189");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A new client connected from " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String message = in.readUTF();

                // Here we will validate the message. This is a simplistic check
                // and a real application would need a more sophisticated method
                if (message.equals("Hello")) {
                    System.out.println("Message received: " + message);
                    out.writeUTF("Message received");
                } else {
                    System.out.println("Invalid message received: " + message);
                    out.writeUTF("Invalid message received");
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}