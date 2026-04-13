import java.net.*;
import java.io.*;

public class java_34916_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234; // default port
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection");
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_34916_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle client communication
            while (true) {
                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Reply to client
                output.writeUTF("Server received your message: " + message);
                output.flush();
            }
        } catch (IOException ex) {
            System.out.println("Error handling client connection");
        }
    }
}