import java.io.*;
import java.net.*;

public class java_41620_SocketServer_A01 {
    public static void main(String[] args) {
        // Create a socket server at port 6000
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server started at port 6000...");

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = dis.readUTF();
                System.out.println("Received message: " + message);

                // Send response back to client
                String response = "Hello, client!";
                dos.writeUTF(response);

                // Close the connection
                dos.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}