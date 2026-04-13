import java.io.*;
import java.net.*;

public class java_41186_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_41186_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message = reader.readLine();
            System.out.println("Received: " + message);

            // Send a message back to the client
            writer.write("Hello, Client!".getBytes());
            writer.newLine();
            writer.flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}