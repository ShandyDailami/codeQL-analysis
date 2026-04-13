import java.io.*;
import java.net.*;

public class java_26582_SocketServer_A03 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new thread to handle the client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_26582_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle incoming client messages
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client says: " + message);

                // Simulate injection
                // Do not use this code, it's only for example and to test injection
                // In a real application, you should use a proper library or framework
                // that handles security, not a simple string concatenation
                out.println("Server says: Hello, " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}