import java.io.*;
import java.net.*;

public class java_12585_SocketServer_A08 {

    private static final int port = 8080;
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Starting server at port " + port);

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }

        while (running) {
            try {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Create new threads for each connection
                new Thread(new SocketHandler(socket)).start();
            } catch (IOException e) {
                System.err.println("Accept failed on port " + port);
                System.exit(-1);
            }
        }
    }

    public static class SocketHandler implements Runnable {
        private Socket socket;
        public java_12585_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Get input and output streams from the socket
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Handle communication with client
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    // Handle integrity failure logic here

                    // Send acknowledgement back to client
                    out.println("ACK");
                }

                // Close connections
                out.close();
                socket.close();

            } catch (IOException e) {
                System.err.println("Error handling client " + socket.getRemoteSocketAddress());
            }
        }
    }
}