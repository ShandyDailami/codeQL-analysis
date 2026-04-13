import java.net.*;
import java.io.*;

public class java_05957_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Waiting for client on port: " + server.getLocalPort() + "...");

            Socket socket = server.accept();
            System.out.println("Connected to client on port: " + socket.getLocalPort() + ".");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // Reading message from client
            String message = dataInputStream.readUTF();
            System.out.println("Received message from client: " + message);

            // Sending response to client
            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);

            // Close the connection
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}