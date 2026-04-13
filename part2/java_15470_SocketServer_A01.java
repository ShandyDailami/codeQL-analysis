import java.io.*;
import java.net.*;

public class java_15470_SocketServer_A01 {

    private static final int PORT = 1234;

    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(PORT)) {

            System.out.println("Server started on port " + PORT);

            while (true) {

                Socket socket = server.accept();

                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
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
    private BufferedReader reader;
    private PrintWriter writer;

    public java_15470_SocketServer_A01(Socket socket) {
        this.socket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        String message;

        while (true) {

            try {
                if ((message = reader.readLine()) != null) {
                    System.out.println("Received message from client: " + message);

                    // Here you can implement any security-sensitive operations

                    writer.println("Message received successfully");
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}