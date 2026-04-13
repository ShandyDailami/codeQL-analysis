import java.io.*;
import java.net.*;

public class java_33595_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create a new thread for each client
            new Thread(() -> {
                try {
                    // Create a new input stream and output stream for the client
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    // Send a welcome message to the client
                    dos.writeUTF("Welcome to the server!");

                    // Receive a message from the client
                    String message = dis.readUTF();
                    System.out.println("Received message from client: " + message);

                    // Close the connections
                    dos.close();
                    dis.close();
                    socket.close();

                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}