import java.net.*;
import java.io.*;

public class java_41691_SocketServer_A08 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(6000); //port number
            System.out.println("Waiting for a client to connect...");

            Socket socket = server.accept();
            System.out.println("Connected to the client");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello Client, you are authenticated!";
            dataOutputStream.writeUTF(serverMsg);
            System.out.println("Server says: " + serverMsg);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}