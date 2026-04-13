import java.net.*;
import java.io.*;

public class java_38452_SocketServer_A01 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(6000); // Server port
        System.out.println("Server started at port 6000");

        while (true) {
            Socket socket = server.accept(); // Waiting for client
            System.out.println("Client connected");

            // Start a new thread to handle the client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_38452_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Receive the message from client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to client
            String response = "Hello, client!";
            output.write(response.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}