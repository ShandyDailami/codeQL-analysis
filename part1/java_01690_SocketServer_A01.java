import java.net.*;
import java.io.*;

public class java_01690_SocketServer_A01 {

    public static void main(String[] args) {
        // Create a server socket and a buffer for incoming data
        ServerSocket serverSocket = null;
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Create a server socket and listen on a port
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            // Wait for a connection
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Create a new thread to handle the communication
            Thread thread = new Thread(new ClientHandler(in, out, socket));
            thread.start();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the streams and the socket
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    // This is a helper class to handle the communication with a client
    static class ClientHandler implements Runnable {
        private DataInputStream in;
        private DataOutputStream out;
        private Socket socket;

        public java_01690_SocketServer_A01(DataInputStream in, DataOutputStream out, Socket socket) {
            this.in = in;
            this.out = out;
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Send a message to the client
                out.writeUTF("Hello, Client!");

                // Receive a message from the client
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Close the connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}