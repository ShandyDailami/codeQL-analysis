import java.io.*;
import java.net.*;

public class java_02278_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server started at port: 6000");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Create new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_02278_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // For instance, checking if the message contains sensitive information
                if (message.contains("sensitive")) {
                    System.out.println("Access denied for message: " + message);
                    writer.writeBytes("Access denied for message: " + message + "\n");
                } else {
                    writer.writeBytes("Message received: " + message + "\n");
                }
                writer.flush();
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error processing client request");
            e.printStackTrace();
        }
    }
}