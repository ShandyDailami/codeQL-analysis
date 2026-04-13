import java.io.*;
import java.net.*;

public class java_39002_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + ". Message was: " + message);
            out.flush();

            socket.close();
        }
    }
}