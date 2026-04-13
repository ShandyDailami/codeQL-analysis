import java.io.*;
import java.net.*;

public class java_17377_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}