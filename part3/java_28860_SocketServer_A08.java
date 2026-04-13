import java.io.*;
import java.net.*;

public class java_28860_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = dis.readUTF();

            // Print message
            System.out.println("Received message from client: " + message);

            // Send response back to client
            String response = "Hello, client!";
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}