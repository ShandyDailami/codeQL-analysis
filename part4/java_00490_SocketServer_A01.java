import java.io.*;
import java.net.*;

public class java_00490_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(3333); // listen on port 3333
            System.out.println("Server is listening on port 3333");

            while (true) {
                socket = server.accept(); // blocking call
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF(); // blocking call
                System.out.println("Received: " + message);

                out.writeUTF("Server received your message");
                out.flush();

                socket.close(); // close the connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}