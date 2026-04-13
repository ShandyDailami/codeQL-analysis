import java.io.*;
import java.net.*;

public class java_11840_SocketServer_A08 {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server started. Listening on port " + PORT + "...");

        while (true) {
            Socket client = server.accept();

            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            // Create a new thread for each client
            new ServerThread(client).start();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public java_11840_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            closeConnection();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Handle the received message here
                // For now, we'll just send a response back
                writer.println("Server received your message: " + message);
            }
        } catch (IOException e) {
            closeConnection();
        }
    }

    private void closeConnection() {
        System.out.println("Connection closed");
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}