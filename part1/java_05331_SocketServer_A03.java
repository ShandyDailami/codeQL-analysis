import java.io.*;
import java.net.*;

public class java_05331_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected!");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }
}