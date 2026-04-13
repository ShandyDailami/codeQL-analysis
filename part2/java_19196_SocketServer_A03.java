import java.io.*;
import java.net.*;

public class java_19196_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at " + new Date());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + new Date());

            // Data Streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send message back to client
            String response = "Hello, client, your message was '" + message + "'";
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}