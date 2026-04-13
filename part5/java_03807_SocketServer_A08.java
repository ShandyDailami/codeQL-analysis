import java.io.*;
import java.net.*;

public class java_03807_SocketServer_A08 {

    private static final String NAME = "Vanilla Server";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected from " + client.getRemoteSocketAddress());

                // Here we're creating new threads for each client. This may not be the best way to handle multiple clients, but for simplicity, we'll do this way.
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection");
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_03807_SocketServer_A08(Socket s) {
            socket = s;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Here we're simulating a failure by echoing back the message. This is a basic form of integrity failure.
                    out.println(message);

                    // We're not checking for actual integrity failure, but we're not going to break the connection here.
                    // If we did, we'd need to parse the message to ensure it's valid.
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}