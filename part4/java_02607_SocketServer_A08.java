import java.io.*;
import java.net.*;

public class java_02607_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Reading data from the client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = dis.readUTF();
            System.out.println("Received from client: " + message);

            // Warning: You should not print or log the message in real-world scenarios.
            // Here for demo purposes.

            // Sending acknowledgment back to client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Message received, thank you!");
            dos.flush();

            socket.close();
        }
    }
}