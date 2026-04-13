import java.io.*;
import java.net.*;

public class java_07734_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8888; // default port for simplicity

        // Parse command line arguments
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Usage: SocketServer <port>");
                System.exit(-1);
            }
        }

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();

                // Handle the client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07734_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = in.readUTF();

            // Check if the client is trying to break in
            if (message.startsWith("BREAK")) {
                // If so, break the connection
                out.writeUTF("Connection broken by client");
                socket.close();
            } else {
                // If not, reply with a different message
                out.writeUTF("Server: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}