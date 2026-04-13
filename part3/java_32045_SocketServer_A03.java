import java.net.*;
import java.io.*;

public class java_32045_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_32045_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = reader.readLine();

            // Handle the message (do not print it here for simplicity)

            // Send a response back to the client
            writer.write("Hello, client!".getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}