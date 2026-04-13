import java.net.*;
import java.io.*;

public class java_10075_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            // Create streams for sending and receiving data
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = dis.readUTF();

            // Process the message (this is where you would run your code to prevent injection attacks)
            String processedMessage = processMessage(message);

            // Send the processed message back to the client
            dos.writeUTF(processedMessage);
            dos.flush();

            socket.close();
        }
    }

    private static String processMessage(String message) {
        // This is a simple example of code to prevent injection attacks.
        // In reality, you would likely use a more complex method of code to prevent injection.
        return "Processed message: " + message;
    }
}