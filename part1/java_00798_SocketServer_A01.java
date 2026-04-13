import java.io.*;
import java.net.*;

public class java_00798_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for this client
                new ClientThread(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class ClientThread extends Thread {
    private Socket socket;

    public java_00798_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle incoming messages from client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Check for specific security-sensitive operation
                if (message.equals("BREAK")) {
                    System.out.println("Breaking access!");
                    break;
                }
            }

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}