import java.io.*;
import java.net.*;

public class java_20855_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected.");

                // Create input and output stream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Check if user is authenticated
                String userAuth = in.readUTF();
                System.out.println("User is authenticated: " + userAuth);

                if (!userAuth.equals("admin")) {
                    out.writeUTF("Authentication failed.");
                    out.flush();
                    socket.close();
                    System.out.println("Authentication failed. Client disconnected.");
                    continue;
                }

                // If user is authenticated, read and send a message
                String message = in.readUTF();
                System.out.println("Received message: " + message);
                out.writeUTF("Message received.");
                out.flush();

                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}