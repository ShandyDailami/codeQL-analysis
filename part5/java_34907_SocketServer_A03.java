import java.io.*;
import java.net.*;

public class java_34907_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Start receiving messages
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);

                    // Simulate a security-sensitive operation
                    // This is a simple example of SQL injection, but in a real scenario, you should not use this method
                    if (message.contains("DROP TABLE")) {
                        out.writeUTF("SQL injection attempt detected");
                        out.flush();
                        break;
                    }

                    out.writeUTF("Thank you for message");
                    out.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}