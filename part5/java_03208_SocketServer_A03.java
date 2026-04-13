import java.io.*;
import java.net.*;

public class java_03208_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started at port: " + serverSocket.getLocalPort());

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03208_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Respond to client
            String response = "Server says: " + message;
            output.writeUTF(response);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}