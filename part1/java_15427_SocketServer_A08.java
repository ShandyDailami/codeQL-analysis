import java.io.*;
import java.net.*;

public class java_15427_SocketServer_A08 {
    private static final String SERVER_NAME = "A08_IntegrityFailure_Server";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // create a new thread for each client connection
            new SocketHandler(socket).start();
        }
    }

    private static class SocketHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_15427_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Failed to open I/O for the client.");
                e.printStackTrace();
            }
        }

        public void run() {
            String clientMessage;
            try {
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    // handle the message here (e.g., check for integrity failure)
                    // if necessary, then send a response back
                    out.println("Server response: " + clientMessage);
                }
            } catch (IOException e) {
                System.out.println("Failed to read from the client.");
                e.printStackTrace();
            }

            closeConnection();
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close the connection.");
                e.printStackTrace();
            }
        }
    }
}