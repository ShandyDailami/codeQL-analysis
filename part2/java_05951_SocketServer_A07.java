import java.io.*;
import java.net.*;
import java.util.*;

public class java_05951_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication failed";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected...");

            // Handling the client
            new Handler(socket).start();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_05951_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            String message;
            try {
                // Read from client
                message = reader.readLine();
                System.out.println("Received: " + message);

                // Authentication
                if (message.equals("admin")) {
                    writer.println(AUTHENTICATION_SUCCESS);
                } else {
                    writer.println(AUTHENTICATION_FAILURE);
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