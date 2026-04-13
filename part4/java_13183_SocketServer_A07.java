import java.io.*;
import java.net.*;

public class java_13183_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("Waiting for a client...");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // Create streams
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        // Handle input and output
        while (true) {
            String message = input.readUTF();

            if (message.equals("exit")) {
                break;
            }

            output.writeUTF("Server received: " + message);
       
            System.out.println("Sent message to client: " + message);
        }

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}