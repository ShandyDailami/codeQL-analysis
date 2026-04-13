import java.net.*;
import java.io.*;

public class java_30919_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for client...");
            Socket socket = server.accept();
            System.out.println("Client accepted!");

            // Handle client
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = dis.readUTF();
            System.out.println("Received: " + request);

            // Send response
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}