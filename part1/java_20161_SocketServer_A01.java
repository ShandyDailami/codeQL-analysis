import java.io.*;
import java.net.*;

public class java_20161_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = "Hello, Client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            socket.close();
        }
    }
}