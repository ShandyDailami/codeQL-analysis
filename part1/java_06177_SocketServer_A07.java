import java.io.*;
import java.net.*;

public class java_06177_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Waiting for client...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create a new thread for each connection
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

    public java_06177_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read from client
            DataInputStream in = new DataInputStream(input);
            DataOutputStream out = new DataOutputStream(output);

            // Send a welcome message
            String message = "Welcome!";
            out.writeUTF(message);

            // Read the response from the client
            message = in.readUTF();
            System.out.println("Server says: " + message);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}