import java.io.*;
import java.net.*;

public class java_38453_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Connected to client");

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = input.readUTF()) != null) {
                System.out.println("Received message: " + message);
                output.writeUTF("Thank you for connecting to the server " + message);
           
            }
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}