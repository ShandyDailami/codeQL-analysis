import java.io.*;
import java.net.*;

public class java_03326_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);
                if (message.equals("exit")) {
                    socket.close();
                    server.close();
                    System.out.println("Connection closed");
                    break;
                }
                out.writeUTF("Server: " + message);
            }
        }
    }
}