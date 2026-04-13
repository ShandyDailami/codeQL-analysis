import java.io.*;
import java.net.*;

public class java_32598_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_32598_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Input stream
            DataInputStream input = new DataInputStream(socket.getInputStream());

            // Output stream
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = input.readUTF();

            // Send a response back to the client
            output.writeUTF("Server accepted your connection: " + request);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}