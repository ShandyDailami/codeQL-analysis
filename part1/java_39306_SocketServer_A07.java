import java.io.*;
import java.net.*;

public class java_39306_SocketServer_A07 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create streams for input and output
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Handle client's input
                new Thread(new ClientHandler(input, output)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private DataInputStream input;
        private DataOutputStream output;

        public java_39306_SocketServer_A07(DataInputStream input, DataOutputStream output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public void run() {
            try {
                // Receive message from client
                String message = input.readUTF();
                System.out.println("Received message: " + message);

                // Send message back to client
                output.writeUTF("Message received: " + message);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}