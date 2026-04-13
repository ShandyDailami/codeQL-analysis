import java.io.*;
import java.net.*;

public class java_00929_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive the message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Check if the message is a command to stop the server
                if (message.equals("/exit")) {
                    out.writeUTF("Server stopped");
                    socket.close();
                    serverSocket.close();
                    System.out.println("Server stopped");
                    System.exit(0);
                }

                // Check if the message is a command to set a password
                if (message.startsWith("/password ")) {
                    String[] parts = message.split("/password ");
                    if (parts.length != 2 || parts[1].length() < 8) {
                        out.writeUTF("Invalid password");
                    } else {
                        // Here you would typically compare the password to a hash and a salt.
                        // This is a simplistic example and does not include the actual implementation.
                        out.writeUTF("Password set");
                    }
                }

                // Send a response back to the client
                out.writeUTF("Server received your message");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}