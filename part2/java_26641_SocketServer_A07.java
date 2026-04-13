import java.io.*;
import java.net.*;

public class java_26641_SocketServer_A07 {
    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(5000); // creates a server socket on port 5000
            System.out.println("Waiting for client...");

            // accept client socket
            socket = server.accept();
            System.out.println("Client connected!");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read from client
            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            // respond to client
            String serverMsg = "Hello, client!";
            out.writeUTF(serverMsg);
            System.out.println("Server says: " + serverMsg);

            // close resources
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}