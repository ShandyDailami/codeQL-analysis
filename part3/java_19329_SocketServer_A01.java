import java.io.*;
import java.net.*;

public class java_19329_SocketServer_A01 {

    // Create a new server thread for each client connection
    public static class ClientHandler implements Runnable {
        private Socket socket;

        public java_19329_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Create input stream and output stream
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                // Read the client's message
                DataInputStream dis = new DataInputStream(input);
                DataOutputStream dos = new DataOutputStream(output);
                String message = dis.readUTF();

                // Log the message
                System.out.println("Received: " + message);

                // Echo the message back to the client
                dos.writeUTF("Message received: " + message);
                dos.flush();

                // Close the socket
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket server = new ServerSocket(5000);

        while (true) {
            // Accept a new client connection
            Socket socket = server.accept();

            // Create a new thread for the client handler
            Thread thread = new Thread(new ClientHandler(socket));

            // Start the client handler thread
            thread.start();
        }
    }
}