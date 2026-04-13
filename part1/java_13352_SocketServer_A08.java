import java.io.*;
import java.net.*;

public class java_13352_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at: " + socket.getInetAddress().getHostAddress());

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive a message from client
            String message = dis.readUTF();
            System.out.println("Received message from client: " + message);

            // Check if the message is valid (for instance, check if it's an integer)
            int number;
            try {
                number = Integer.parseInt(message);
                if (number < 0) {
                    throw new Exception("Invalid number");
                }
            } catch (Exception e) {
                // If the message is not a valid number, send an error message back
                dos.writeUTF("Invalid number");
                dos.flush();
                continue;
            }

            // If the message is valid, send a response back
            dos.writeUTF("Valid number");
            dos.flush();

            socket.close();
       
        }
    }
}