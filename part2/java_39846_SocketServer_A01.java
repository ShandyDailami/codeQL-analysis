import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39846_SocketServer_A01 {

    private static final String PASSWORD = "securePassword"; // This should be a secure password

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Define the port
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_39846_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input stream and check if password is correct
                java.io.InputStream input = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int length = input.read(bytes);
                String password = new String(bytes, 0, length);
                if (!PASSWORD.equals(password)) {
                    System.out.println("Password is incorrect");
                    return;
                }

                // Password is correct, now we can read from and write to the socket
                java.io.OutputStream output = socket.getOutputStream();
                String response = "Access granted";
                output.write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}