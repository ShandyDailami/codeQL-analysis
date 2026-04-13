import java.io.*;
import java.net.*;

public class java_02496_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                // Perform security-sensitive operations related to Injection
                // Here, we're assuming that the client's message contains a command
                // The server then interprets the command and performs the requested action

                // Assume the client sends a message
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String message = dis.readUTF();

                System.out.println("Received message: " + message);

                // Assume the server sends a response back to the client
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                String response = "Server received the message: " + message;
                dos.writeUTF(response);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}