import java.io.*;
import java.net.*;

public class java_13083_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(6000); // Listening port
            System.out.println("Waiting for client...");
            socket = server.accept(); // Accepting client connection
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while((clientMessage = input.readUTF()) != null) {
                System.out.println("Received from client: " + clientMessage);

                if(clientMessage.equals("quit")) {
                    System.out.println("Client disconnected!");
                    break;
                }

                System.out.println("Sending to client: Hello, client!");
                output.writeUTF("Hello, client!");
            }

            socket.close();
            server.close();

        } catch(IOException ex) {
            ex.printStackTrace();
        } finally {
            // Ensuring the resources are closed
        }
    }
}