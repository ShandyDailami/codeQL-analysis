import java.io.*;
import java.net.*;

public class java_04112_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Waiting for connection...");

            Socket client = server.accept();
            System.out.println("Connection established!");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            while(true) {
                String message = in.readUTF();
                System.out.println("Client says: " + message);
                out.writeUTF("Server says: " + message);
                out.flush();

                if (message.equals("close")) break;
            }

            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}