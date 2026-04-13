import java.io.*;
import java.net.*;

public class java_03878_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            server = new ServerSocket(3200); // Set a port number
            System.out.println("Server is listening on port 3200");

            while (true) {
                socket = server.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());

                // Receive data from client and send back to client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Sending message back to client
                String response = "Message from server: " + message;
                dos.writeUTF(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}