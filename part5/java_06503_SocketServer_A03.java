import java.io.*;
import java.net.*;

public class java_06503_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started at port 5000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            // Create new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_06503_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the message from the client
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String clientMessage = input.readUTF();

            // Process the message (remove injection here, for example)
            clientMessage = processMessage(clientMessage);

            // Write the response back to the client
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(clientMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processMessage(String message) {
        // Add your own logic for security-sensitive operations related to injection
        // For example, use a whitelist to allow certain commands, or use a more complex
        // method of processing the input to prevent injection attacks
        return message;
    }
}