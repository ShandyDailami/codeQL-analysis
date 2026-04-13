import java.io.*;
import java.net.*;

public class java_29947_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for connection...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF(message);
            out.flush();

            socket.close();
        }
    }
}