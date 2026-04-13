import java.io.*;
import java.net.*;

public class java_39533_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started at port: " + server.getLocalPort());

            while(true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Reading the message from the client
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String clientMessage = dis.readUTF();
                System.out.println("Client says: " + clientMessage);

                // Writes a response back to the client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String serverMessage = "Server says: Hello, Client";
                dos.writeUTF(serverMessage);
                System.out.println("Server says: " + serverMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}