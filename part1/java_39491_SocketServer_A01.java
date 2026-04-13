import java.net.*;
import java.io.*;

public class java_39491_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening...");

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Message received: " + message);

                if (message.equals("BREAK")) {
                    System.out.println("Client disconnected!");
                    break;
                }

                dos.writeUTF("Message received");
                dos.flush();
           
            }
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}