import java.io.*;
import java.net.*;

public class java_05091_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started.");

        while (true) {
            // Wait for client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread for the client
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_05091_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the client's message
            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            // Send a response
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}