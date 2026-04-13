import java.io.*;
import java.net.*;

public class java_36381_SocketServer_A01 {
    private static final String SERVER_STATE = "SERVER_STATE";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Client connected!");

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
       .
        .
        .
        // Complete the code here
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_36381_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from client
            String message = in.readUTF();

            // Echo the message back to the client
            out.writeUTF("Echo: " + message);
            out.flush();

            socket.close();
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
        }
    }
}