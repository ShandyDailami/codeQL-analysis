import java.io.*;
import java.net.*;

public class java_40888_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Bind to port 8080
        System.out.println("Server started on port 8080. Waiting for connections...");

        while (true) {
            Socket socket = server.accept();

            // Create a new thread to handle the client request
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_40888_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read a message from the client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Check if the message is "quit"
            if (message.equals("quit")) {
                socket.close();
            } else {
                // Return a greeting back to the client
                output.writeUTF("Hello, client!");
                output.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}