import java.io.*;
import java.net.*;

public class java_36671_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection from: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // TODO: Implement secure communication
            // e.g., you can use SSL/TLS for secure communication

            // Here you can implement other operations such as authentication, data encryption, etc.
            // In the real world, these operations are performed using a secure communication protocol

            // For the sake of example, let's just echo back the received message
            output.writeUTF(message);
            output.flush();
       
            socket.close();
        }
    }
}