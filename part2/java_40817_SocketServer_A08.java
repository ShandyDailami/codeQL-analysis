import java.net.*;
import java.io.*;

public class java_40817_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read from client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send a response
                out.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}