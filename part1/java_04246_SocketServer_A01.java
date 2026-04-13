import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04246_SocketServer_A01 {

    private static ExecutorService executor = Executors.newFixedThreadPool(5);
    private static StringBuilder response = new StringBuilder();
    private static boolean running = true;

    public static void main(String[] args) {

        // Starting the server
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is running...");

            while (running) {
                Socket client = server.accept();
                System.out.println("Client accepted: " + client.getRemoteSocketAddress());
                executor.execute(new SocketHandler(client));
            }

            executor.shutdown();

        } catch (IOException ex) {
            System.err.println("Error accepting client connection: " + ex);
        }
    }

    static class SocketHandler implements Runnable {

        Socket socket;
        BufferedReader in;
        PrintWriter out;

        SocketHandler(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.err.println("Error creating I/O for a client.");
            }
        }

        public void run() {
            try {
                String message, reply;
                while ((message = in.readLine()) != null) {
                    response.append("Received: " + message);
                    // Perform decryption here
                    reply = decrypt(message);
                    out.println("Reply: " + reply);
                }
                out.close();
                in.close();
                socket.close();
            } catch (IOException ex) {
                System.err.println("Error handling client: " + ex);
            }
        }

        // Encryption method
        String encrypt(String message) {
            // Implement encryption here
            return message;
        }

        // Decryption method
        String decrypt(String message) {
            // Implement decryption here
            return message;
        }
    }
}