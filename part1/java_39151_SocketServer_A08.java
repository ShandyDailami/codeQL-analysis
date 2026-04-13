import java.io.*;
import java.net.*;

public class java_39151_SocketServer_A08 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create data input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Check if message is null or empty, respond back with error message
                if (message == null || message.isEmpty()) {
                    out.writeUTF("Error: Invalid message received");
                } else {
                    // Check if message is "exit", close the connection
                    if (message.equals("exit")) {
                        out.writeUTF("Connection closed");
                    } else {
                        // Check if message is "password", check against hardcoded password, respond back with authentication failure
                        if (message.equals("password")) {
                            String hardcodedPassword = "1234";
                            if (checkPassword(in, hardcodedPassword)) {
                                out.writeUTF("Successfully authenticated");
                            } else {
                                out.writeUTF("Authentication failed");
                           
                        } else {
                            // Otherwise, send back the message to the client
                            out.writeUTF("Server: " + message);
                        }
                    }
                }

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to check password
    private static boolean checkPassword(DataInputStream in, String hardcodedPassword) {
        String password = null;
        try {
            password = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password != null && password.equals(hardcodedPassword);
    }
}