import java.io.*;
import java.net.*;

public class java_07924_SocketServer_A08 {
    private static int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                // Send back message to client
                dos.writeUTF("Message received");
                dos.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}