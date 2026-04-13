import java.io.*;
import java.net.*;

public class java_11507_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Handle specific security-sensitive operations related to A01_BrokenAccessControl
            while (true) {
                String message = in.readUTF();
                if (message.equals("exit")) {
                    break;
                }
                // Calls to a secure operation
                System.out.println("Received message: " + message);
                out.writeUTF("Response from server: " + message);
                out.flush();
           
            }

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}