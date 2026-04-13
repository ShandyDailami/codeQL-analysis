import java.io.*;
import java.net.*;

public class java_19646_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000); // Server port
        System.out.println("Server started on port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive message from client
            String clientMsg = in.readUTF();
            System.out.println("Received: " + clientMsg);

            // Respond to client
            String serverMsg = "Hello, client!";
            out.writeUTF(serverMsg);
            System.out.println("Sent: " + serverMsg);

            // Close connection
            socket.close();
        }
    }
}