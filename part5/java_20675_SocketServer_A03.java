import java.io.*;
import java.net.*;

public class java_20675_SocketServer_A03 {

    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public java_20675_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    String response = handleInput(input);
                    out.println(response);
                    out.flush();
                }
            } catch (IOException e) {
                close();
            }
        }

        private String handleInput(String input) {
            // Add your security-sensitive operations related to A03_Injection here
            // For example: sanitize the input to prevent SQL injection, XSS attacks, etc.
            return "Server response: " + input;
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Do nothing
            }
        }
    }
}