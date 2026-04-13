import java.io.*;
import java.net.*;

public class java_26364_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Port number
        System.out.println("Server is listening at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            // Create input and output stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send response to client
            String response = "Hello, client!";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
        }
    }
}