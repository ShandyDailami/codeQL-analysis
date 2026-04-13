import java.io.*;
import java.net.*;

public class java_24460_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 6666;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the connection
                new HandleConnectionThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + port);
        }
    }
}

class HandleConnectionThread extends Thread {

    private Socket socket;

    public java_24460_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Get message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send response back to client
            output.writeUTF("Message received");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}