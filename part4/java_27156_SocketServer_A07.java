import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class java_27156_SocketServer_A07 {

    private static final int PORT = 12345;
    private static final String LOCAL_IP = "localhost";

    public static void main(String[] args) throws Exception {
        // Start the server
        ServerSocket serverSocket = new ServerSocket(PORT, 1, InetAddress.getByName(LOCAL_IP));
        System.out.println("Server is running on port: " + PORT + " (local IP: " + LOCAL_IP + ")");

        while (true) {
            // Accept a new connection
            Socket socket = serverSocket.accept();

            // Create a new thread for handling the client request
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_27156_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String request;
            try {
                // Read the request from the client
                request = reader.readLine();

                // Check if the request is valid
                if ("A07_AuthFailure".equals(request)) {
                    // If the request is valid, send a response
                    writer.println("AuthSuccess");
                } else {
                    writer.println("InvalidRequest");
                }

            } catch (Exception e) {
                // Handle any exceptions that may occur during the request handling
                e.printStackTrace();
            }
        }
    }
}