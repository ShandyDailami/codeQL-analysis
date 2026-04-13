import java.io.*;
import java.net.*;

public class java_36896_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Writes and reads from the socket
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Attempting to write a string
            out.writeUTF("Hello Client!");
            System.out.println("Client says: " + in.readUTF());

            // After reading, server must close the connection
            out.close();
            in.close();
            socket.close();
       
        }
    }
}