import java.io.*;
import java.net.*;

public class java_12613_SocketServer_A08 {
    private static int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Check if the message is "exit"
            if (message.equals("exit")) {
                System.out.println("Disconnected from " + socket.getRemoteSocketAddress());
                break;
            }

            // Generate a response
            String response = "Hello, Client!";
            dos.writeUTF(response);

            // Close the streams
            dos.close();
            dis.close();
       
        }

        server.close();
    }
}