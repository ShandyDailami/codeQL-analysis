import java.io.*;
import java.net.*;

public class java_17929_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            // Handle the request in a separate thread
            new HandlerThread(socket).start();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_17929_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // Read the request
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Process the request (security-sensitive operation)
                if (request.contains("injection")) {
                    // If the request contains a known injection, return a response
                    out.println("Injection detected");
                } else {
                    // Otherwise, just echo back the request
                    out.println("Hello, " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}