import java.io.*;
import java.net.*;

public class java_37666_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000); // listen on port 5000
            System.out.println("Server started on port 5000...");

            while (true) {
                Socket socket = server.accept(); // wait for client connection
                System.out.println("Client connected...");

                // Handle the client connection in a separate thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_37666_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Authentication
                    if ("exit".equals(message)) {
                        writer.println("Authentication failed!");
                        break;
                    } else {
                        writer.println("Authentication successful!");
                    }
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}