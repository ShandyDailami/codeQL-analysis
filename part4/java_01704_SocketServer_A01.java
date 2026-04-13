import java.io.*;
import java.net.*;

public class java_01704_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            serverSocket = new ServerSocket(12345); // bind the server to port 12345
            System.out.println("Server started, waiting for client connection...");

            socket = serverSocket.accept(); // accept client connection
            System.out.println("Client connected");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // send welcome message to the client
            out.writeUTF("Welcome to the server!");

            // read a message from the client and echo it back to the client
            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            out.writeUTF("Thank you for connecting to the server!");

            // close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the streams
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}