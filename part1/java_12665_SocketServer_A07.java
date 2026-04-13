import java.io.*;
import java.net.*;

public class java_12665_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(65534); // Choose a random port
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Perform authentication
                if (!authenticate(socket)) {
                    System.out.println("Authentication failed, closing connection.");
                    socket.close();
                    continue;
                }

                // Create a new input stream
                DataInputStream in = new DataInputStream(socket.getInputStream());

                // Read a message
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Write a reply
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Thank you for connecting, " + message + "!");
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        try {
            // Here you would typically perform some sort of authentication
            // This is a very simple example where we just return true
            return true;
        } catch (Exception ex) {
            // Handle any exceptions that might occur during authentication
            ex.printStackTrace();
            return false;
        }
    }
}