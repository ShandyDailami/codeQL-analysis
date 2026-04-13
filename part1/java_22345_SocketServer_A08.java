import java.io.*;
import java.net.*;

public class java_22345_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a socket server on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Server started on port 1234.");

            // Run a loop to accept client
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client connected.");

                // Create a new thread to handle communication
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_22345_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Input stream from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Output stream to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Check for integrity failure
                if (message.equals("Failure")) {
                    out.println("Integrity failure detected, processing...");

                    // Simulate integrity failure by throwing an exception
                    throw new RuntimeException("Simulated integrity failure");
                } else {
                    out.println("Processed: " + message);
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}