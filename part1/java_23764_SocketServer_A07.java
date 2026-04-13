import java.io.*;
import java.net.*;

public class java_23764_SocketServer_A07 {
    private static final int PORT = 9876;
    private static ServerSocket server;
    private static boolean running = true;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            while (running) {
                new Handler(server.accept()).start();
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23764_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(message)) {
                        close();
                    } else {
                        process(message);
                    }
                }
            } catch (IOException e) {
                close();
            }
        }

        public void process(String message) {
            // TODO: Implement security-sensitive operations related to A07_AuthFailure
            // You can use standard Java libraries for this task
            // For example, you can use the java.security package to implement authentication
            // If the client is not authenticated, send a response back to the client.
            // If the client is authenticated, process the message.
        }

        public void close() {
            running = false;
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}