import java.io.*;
import java.net.*;

public class java_40204_SocketServer_A08 {

    public static void main(String[] args) {

        try {

            // Creating a socket with port 5432 (any available port)
            ServerSocket serverSocket = new ServerSocket(5432);
            System.out.println("Waiting for a client to connect...");

            // Accepting a new client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Creating input and output streams
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Sending a greeting message
            out.writeUTF("Hello Client, Welcome to Socket Server!!");

            // Closing connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}