import java.io.*;
import java.net.*;

public class java_19672_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF();
                System.out.println("Received message: " + clientMessage);

                String serverMessage = "Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Sent message: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}