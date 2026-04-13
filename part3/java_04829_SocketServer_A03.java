import java.io.*;
import java.net.*;

public class java_04829_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server is listening on port 8888");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle communication with the client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_04829_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the client's message
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Welcome the client
            String message = reader.readLine();
            System.out.println("Received message: " + message);
            writer.writeBytes("Welcome to the server!\n");
            writer.flush();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}