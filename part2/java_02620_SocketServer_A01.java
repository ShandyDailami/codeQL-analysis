import java.io.*;
import java.net.*;

public class java_02620_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Server started on port 6789");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("shutdown")) {
                System.out.println("Server shutting down");
                dos.writeUTF("shutdown successful");
                socket.close();
                serverSocket.close();
                break;
            }

            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent message: " + response);
       
            socket.close();
        }
    }
}