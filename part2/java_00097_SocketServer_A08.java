import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00097_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
       
    }

    public static class SocketHandler implements Runnable {
        private Socket socket;

        public java_00097_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For example, read and write data using a BufferedReader and PrintWriter
            try {
                // Write response to client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Server: Hello client!");

                // Read request from client
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = in.readLine();
                System.out.println("Client: " + input);

                // Example of a security-sensitive operation related to integrity failure
                // In a real-world application, this operation should be more complex and error-proof
                // This example assumes that the client's input is a number and the server's response is the square of the input
                int num = Integer.parseInt(input);
                int response = num * num;
                out.println("Server: The square of " + input + " is " + response);
            } catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            }
        }
    }
}