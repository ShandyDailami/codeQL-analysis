import java.io.*;
import java.net.*;

public class java_11060_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while(true) {
                Socket client = server.accept();

                // Create streams
                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                // Handle requests
                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Echo back the message
                output.writeUTF("Echo: " + message);
                output.flush();

                // Close streams
                input.close();
                output.close();
                client.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}