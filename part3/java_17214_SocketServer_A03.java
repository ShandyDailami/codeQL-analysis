import java.io.*;
import java.net.*;

public class java_17214_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();

        System.out.println("Connected to client!");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Reading from the client
        String clientMsg = input.readUTF();
        System.out.println("Client says: " + clientMsg);

        // Sending back to the client
        String serverMsg = "Hello, client!";
        output.writeUTF(serverMsg);
        output.close();
        input.close();
        socket.close();
        server.close();
    }
}