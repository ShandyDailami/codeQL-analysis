import java.net.*;
import java.io.*;

public class java_23680_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555); // Port
            System.out.println("Server started on port 5555");

            while (true) {
                Socket socket = serverSocket.accept(); // Blocking call
                System.out.println("New client connected");

                // Handle client in a new thread
                new HandleClient(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class HandleClient extends Thread {
    private Socket socket;

    public java_23680_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Send response
            out.println("Hello client, you are connected!");

            // Close connection
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}