import java.net.*;
import java.io.*;

public class java_36424_SocketServer_A07 {
    public static void main(String[] args) {
        Socket socket;

        try {
            // Create a server socket with an unbound port
            ServerSocket serverSocket = new ServerSocket(0);

            // Listen for connections
            while (true) {
                System.out.println("Waiting for client...");
                socket = serverSocket.accept();

                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for handling the client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("IOException was caught: " + e.getMessage());
       
        }
    }
}

// Thread for handling a single client
class HandleClientThread extends Thread {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    // Create a new thread for handling one client
    public java_36424_SocketServer_A07(Socket s) {
        socket = s;

        try {
            // Set up input and output streams
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("IOException was caught: " + e.getMessage());
        }
    }

    public void run() {
        String message;

        // Listen for messages from the client
        try {
            while ((message = in.readUTF()) != null) {
                System.out.println("Received message: " + message);

                // Echo the message back to the client
                out.writeUTF(message);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("IOException was caught: " + e.getMessage());
        }

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("IOException was caught: " + e.getMessage());
        }
    }
}