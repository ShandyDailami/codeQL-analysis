import java.io.*;
import java.net.*;

public class java_33866_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5050);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Client message: " + clientMessage);

            out.writeUTF("Server received your message: " + clientMessage);
            out.flush();

            socket.close();
       
        }
    }
}