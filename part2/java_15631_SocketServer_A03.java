import java.net.*;
import java.io.*;

public class java_15631_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for client...");

            Socket client = server.accept();
            System.out.println("Connected to client");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = dis.readUTF()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    break;
                }
                String response = "Server received your message: " + message;
                dos.writeUTF(response);
                dos.flush();
            }

            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}