import java.io.*;
import java.net.*;

public class java_12961_SocketServer_A03 {
    private static final int PORT = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create a new thread for each client
            Thread thread = new Thread(new SocketHandler(clientSocket));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_12961_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error initializing streams or communicating with client");
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Add code here to prevent injection attacks
                    // For example, checking if the message contains special characters
                    if (message.matches(".*\\.*")) {
                        System.out.println("Suspicious activity detected, refusing connection");
                        out.println("Error: Suspicious activity detected");
                        out.close();
                        close(socket, in, out);
                        return;
                    }

                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error reading from client");
            }
        }

        private static void close(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing streams or socket");
            }
        }
    }
}