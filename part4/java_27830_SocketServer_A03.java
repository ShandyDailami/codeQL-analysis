import java.io.*;
import java.net.*;

public class java_27830_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3333);
            System.out.println("Waiting for a client...");
            
            Socket socket = server.accept();
            System.out.println("Connected to the client!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello, client!";
            output.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}