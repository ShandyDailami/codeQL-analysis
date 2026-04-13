import java.io.*;
import java.net.*;

public class java_10272_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Start a new thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    // Thread for handling communication with a client
    static class ClientHandler implements Runnable {

        private Socket socket;

        public java_10272_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                // Receive the message from the client
                DataInputStream dis = new DataInputStream(input);
                String message = dis.readUTF();

                System.out.println("Received: " + message);

                // Send the message back to the client
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF("Message received!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}