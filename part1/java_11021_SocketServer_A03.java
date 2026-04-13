import java.io.*;
import java.net.*;

public class java_11021_SocketServer_A03 {
    private int port;

    public java_11021_SocketServer_A03(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Handle the client connection in a new thread
            new Thread(new ClientHandler(socket)).start();
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer(1234).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_11021_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // read the message from the client
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // send a response back to the client
                writer.println("Server received your message.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}