import java.io.*;
import java.net.*;

public class java_22567_SocketServer_A01 {
    private static final int PORT = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create new thread for each client
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

    public java_22567_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Here, you can implement logic related to security sensitive operations
            // For instance, you might check if the request is valid and then proceed with it

            // Send response
            writer.write("Response from server".getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}