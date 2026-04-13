import java.io.*;
import java.net.*;

public class java_12296_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress() + "\n");
            out.flush();
       
            socket.close();
        }
    }
}