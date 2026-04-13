import java.io.*;
import java.net.*;

public class java_27730_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is running...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A new client has connected!");

            // Start a new thread for each client
            new Thread(() -> {
                try {
                    // Create input and output streams
                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                    // Receive and send messages
                    while (true) {
                        String message = in.readUTF();
                        System.out.println("Client says: " + message);

                        // Simulate injection attempt (e.g., command injection)
                        // In reality, you should sanitize the input to prevent injection attacks
                        if (message.contains("command")) {
                            System.out.println("Command injection attempt detected! Aborting...");
                            out.writeUTF("Aborting due to command injection.");
                            break;
                        }

                        out.writeUTF("Server says: Hello, client!");
                        out.flush();
                    }

                    // Close the connection
                    clientSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}