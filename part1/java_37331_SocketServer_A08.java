import java.io.*;
import java.net.*;

public class java_37331_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 6000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started with port number " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create new threads for each client
                Thread clientThread = new Thread(new SocketHandler(socket));
                clientThread.start();
            }
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to listen on port " + port + ": " + ex);
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_37331_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Perform some security-sensitive operation here, for instance, integrity check.
                // Here's a simple example of a SHA-256 hash check.
                String hash = clientMessage.hashCode() + "a08_integrity_failure"; // Replace with actual operation.
                String serverMessage = hash.substring(0, hash.length() / 2);

                System.out.println("Sending: " + serverMessage);
                writer.println(serverMessage);
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Exception caught when trying to read from or write to client: " + ex);
        }
    }
}