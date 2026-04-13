import java.io.*;
import java.net.*;

public class java_07521_SocketServer_A03 {

    private static int port = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication
                new HandleClientThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    // Inner class for handling communication with a client
    private static class HandleClientThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_07521_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform security-sensitive operation related to A03_Injection
                    // For simplicity, we just echo the message back to the client
                    out.println(message);
                }
            } catch (IOException ex) {
                System.out.println("IOException: " + ex.getMessage());
            }
        }
    }
}