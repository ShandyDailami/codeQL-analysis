import java.io.*;
import java.net.*;

public class java_20328_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server started. Waiting for client connection...");

        Socket socket = server.accept();

        System.out.println("Client connected.");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        out.writeUTF("Thank you for connecting to the server.");
        out.flush();

        socket.close();
   
        System.out.println("Connection closed.");
    }
}