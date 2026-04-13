import java.io.*;
import java.net.*;
import java.util.*;

public class java_02677_SocketServer_A01 {

    // This is a list of users in the system. It is not recommended to use this in a real system.
    private static List<String> userList = Arrays.asList("User1", "User2", "User3");

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Start a new thread to handle communication with the client
                new SocketHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error in server: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static class SocketHandler extends Thread {
        private Socket socket;

        public java_02677_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Get input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Read username
                String username = input.readUTF();
                System.out.println("Received username: " + username);

                // Check access rights
                if (!userList.contains(username)) {
                    output.writeUTF("Access denied");
                    return;
                }

                // Read and echo message
                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Echo back message
                output.writeUTF("Echo: " + message);
            } catch (IOException ex) {
                System.out.println("Error in communication: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}