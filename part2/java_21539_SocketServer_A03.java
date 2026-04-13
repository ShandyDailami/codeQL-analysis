import java.io.*;
import java.net.*;

public class java_21539_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_21539_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Get client message and send back a response
            String clientMessage = reader.readLine();
            System.out.println("Received message: " + clientMessage);

            String serverMessage = processMessage(clientMessage);
            writer.println(serverMessage);

            // Close the socket
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String processMessage(String message) {
        // Here we're simply sanitizing the input message to prevent injection attacks
        // In a real application, you'd likely use a more sophisticated method of sanitizing the input
        return message.replace("<", "&lt;").replace(">", "&gt;");
    }
}