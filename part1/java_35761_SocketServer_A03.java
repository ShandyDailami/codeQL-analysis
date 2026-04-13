import java.io.*;
import java.net.*;

public class java_35761_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Receive message from client
        String clientMessage = in.readUTF();
        System.out.println("Received: " + clientMessage);

        // Send message back to client
        String serverMessage = "Server: Hello, client!";
        out.writeUTF(serverMessage);

        // Close the connection
        socket.close();
   
    }
}