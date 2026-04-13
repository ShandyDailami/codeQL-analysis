import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12963_SocketServer_A03 {

    private static final int PORT = 4445; // you can change the port number

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_12963_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (socket) {
                // Create input and output streams
                java.io.PrintWriter out = new java.io.PrintWriter(socket.getOutputStream(), true);
                java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                }
            } catch (IOException e) {
                System.err.println("Exception caught: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}