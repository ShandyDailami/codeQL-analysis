import java.io.*;
import java.net.*;

public class java_37222_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Start a new thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_37222_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read data from the client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String message = input.readUTF();

            // Process the message (e.g., print it)
            System.out.println("Received: " + message);

            // Send a response back to the client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String response = "Message received";
            output.writeUTF(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}