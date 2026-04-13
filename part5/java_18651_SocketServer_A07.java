import java.io.*;
import java.net.*;

public class java_18651_SocketServer_A07 {
    private static final int port = 12345;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("IOException in server: " + ex.getMessage());
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException in closing server: " + ex.getMessage());
            }
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;
    private BufferedReader reader;
    private DataOutputStream writer;

    public java_18651_SocketServer_A07(Socket socket) {
        this.socket = socket;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("IOException in handler: " + ex.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            // Server reads from the client and sends back to the client
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // Perform authentication
                // If authentication fails, send AuthFailure message
                if (!authenticate(message)) {
                    writer.writeBytes("AuthFailure\n");
                    writer.flush();
                    System.out.println("Auth failed, sending AuthFailure message");
                    return;
                }
                writer.writeBytes("AuthSuccess\n");
                writer.flush();
                System.out.println("Auth success, sending AuthSuccess message");
            }
        } catch (IOException ex) {
            System.out.println("IOException in handler: " + ex.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                System.out.println("IOException in handler cleanup: " + ex.getMessage());
            }
        }
    }

    private boolean authenticate(String message) {
        // Implement authentication logic here
        // For simplicity, we'll just return true for all messages
        return true;
    }
}