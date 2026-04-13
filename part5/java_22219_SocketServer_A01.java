import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22219_SocketServer_A01 {
    private static final int PORT = 9876; // Change this to the port you want to use

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start. Exiting...");
            System.exit(-1);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_22219_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here you can perform security-sensitive operations
                // For example, check if the message is a command for admin access
                if (message.equals("/admin")) {
                    out.println("Access denied!");
                    out.flush();
                    continue; // Skip further processing
                }
                // If message is not a command, send back a response
                out.println("Hello, client!");
                out.flush();
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}