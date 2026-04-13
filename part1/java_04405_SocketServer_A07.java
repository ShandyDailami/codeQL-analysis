import java.net.*;
import java.io.*;
import java.util.*;

public class java_04405_SocketServer_A07 {
    public static void main(String args[]) {
        int port = 6789; //default port
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Perform authentication
                boolean authSuccess = authenticate(in.readUTF());

                if (!authSuccess) {
                    // Authentication failed, close connection
                    out.writeUTF("Auth failure");
                    socket.close();
                    continue;
                }

                // If authentication succeeded, send a welcome message
                out.writeUTF("Welcome to the server!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mock authentication function
    private static boolean authenticate(String message) {
        // This is a simple mock authentication function
        // For a real-world application, consider using stronger authentication measures
        return message.equals("correctpassword");
    }
}