import java.io.*;
import java.net.*;

public class java_37366_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create streams for communication
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read and echo back messages
            while (true) {
                String message = dis.readUTF();
                if (message == null || message.equals("exit")) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    System.out.println("Received: " + message);
                    dos.writeUTF("Echo: " + message);
                    dos.flush();
                }
            }

            // Close the streams
            dos.close();
            dis.close();
        }
    }
}