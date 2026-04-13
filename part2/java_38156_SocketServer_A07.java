import java.io.*;
import java.net.*;

public class java_38156_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Create new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_38156_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);
                    // Here you can add your security-sensitive operations
                    // For example, checking for a specific authentication token
                    if ("A07_AuthFailure".equals(message)) {
                        out.println("Authentication failed, sorry!");
                        out.close();
                        socket.close();
                    } else {
                        out.println("OK");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}