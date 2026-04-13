import java.io.*;
import java.net.*;
import java.util.*;

public class java_19325_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the request
            new HandlerThread(socket).start();
        }
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_19325_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Process the request (this is where we perform security-sensitive operations)
            // Here, we simply echo the request back to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Echo: " + request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}