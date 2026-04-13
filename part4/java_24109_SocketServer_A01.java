import java.net.*;
import java.io.*;

public class java_24109_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4445);
            System.out.println("Server started on port 4445");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Send a welcome message
                dos.writeUTF("Welcome to the server! Connected successfully.");

                // Receive client's message and send back a response
                String message = dis.readUTF();
                System.out.println("Client says: " + message);
                String response = "Server says: Hello, " + message + "!";
                dos.writeUTF(response);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}