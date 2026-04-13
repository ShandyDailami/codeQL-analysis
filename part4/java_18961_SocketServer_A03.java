import java.io.*;
import java.net.*;

public class java_18961_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for this client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader reader;

    public java_18961_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Echo the message back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the client connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}