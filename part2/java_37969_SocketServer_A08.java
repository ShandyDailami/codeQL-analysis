import java.io.*;
import java.net.*;

public class java_37969_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read client message
            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            // Send response to client
            String response = "Hello, Client!";
            dos.writeUTF(response);
            System.out.println("Sent response: " + response);

            socket.close();
        }
    }
}