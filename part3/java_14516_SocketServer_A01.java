import java.io.*;
import java.net.*;

public class java_14516_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected.");

            // Use a new thread for each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    public java_14516_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            writer.writeBytes("Welcome to the server!\n");

            // Read a line from the client
            String line = reader.readLine();
            System.out.println("Received: " + line);

            // Close the connection
            writer.writeBytes("Connection closed.\n");
            writer.flush();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}