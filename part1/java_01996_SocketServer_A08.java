import java.io.*;
import java.net.*;

public class java_01996_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            if (message.equalsIgnoreCase("exit")) {
                out.writeUTF("Server is exiting");
                socket.close();
                System.out.println("Connection closed by client");
                break;
            } else {
                out.writeUTF("Server received your message");
            }

            out.close();
            in.close();
       
            socket.close();
        }

        server.close();
    }
}