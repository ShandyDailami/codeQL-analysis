import java.io.*;
import java.net.*;

public class java_26149_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while(true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message;
            while(!(message = dis.readUTF()).equals("exit")) {
                System.out.println("Received: " + message);
                dos.writeUTF(message);
                dos.flush();
            }

            socket.close();
        }
    }
}