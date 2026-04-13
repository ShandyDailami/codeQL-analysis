import java.net.*;
import java.io.*;

public class java_39146_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Create new thread for each client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_39146_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                // Read message from client
                if ((message = in.readLine()) != null) {
                    // Send the message back to the client
                    out.println("Message received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
           
                // Close the connection when exception occurs
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}