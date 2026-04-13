import java.io.*;
import java.net.*;

public class java_00481_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            while(true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();

                System.out.println("Received message: " + message);

                out.writeUTF("Message received");
                out.flush();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}