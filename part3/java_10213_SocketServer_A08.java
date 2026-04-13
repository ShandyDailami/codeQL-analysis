import java.io.*;
import java.net.*;

public class java_10213_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(8080); // listen on port 8080
            System.out.println("Waiting for client on port 8080...");

            socket = serverSocket.accept(); // accept connection
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // send a message to the client
            out.writeUTF("Hello Client, You are Connected to the Server!");

            // receive a message from the client
            String message = in.readUTF();
            System.out.println("Server received: " + message);

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}