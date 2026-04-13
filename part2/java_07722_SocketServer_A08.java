import java.io.*;
import java.net.*;

public class java_07722_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(0); // Binding to any available port
        System.out.println("Server is listening on port: " + server.getLocalPort());

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection from: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Reading message from client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Sending message back to client
            dos.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());
            dos.flush();

            socket.close();
        }
    }
}