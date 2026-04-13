import java.net.*;
import java.io.*;

public class java_11411_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // bind the server socket to port 4444
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept(); // accept a connection
                System.out.println("Client connected");

                // create a new thread to handle communication
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
    private BufferedReader reader;
    private PrintWriter writer;

    public java_11411_SocketServer_A01(Socket socket) {
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
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                // perform security sensitive operations
                performSecuritySensitiveOperations(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void performSecuritySensitiveOperations(String message) {
        // TODO: Implement security sensitive operations using the message
        // For example, check if the message contains sensitive information and block/remove it if it does
    }
}