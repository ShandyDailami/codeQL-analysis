import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27860_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Handle the connection in a separate thread
            new Handler(socket).start();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public java_27860_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle the client connection, for example, by reading and writing data
            try {
                // Here you can use security libraries like java.security for adding restrictions on what kind of data can be sent to the client
                // But you need to be careful not to send or receive any data that the client doesn't want to be exposed.
                // For example, you might not allow the client to send their own username or password.
                // But you can send a message like "Welcome back, user X!" or similar.

                // Here you can use InputStream and OutputStream for reading and writing data
                // For example:
                // InputStream input = socket.getInputStream();
                // byte[] buffer = new byte[1024];
                // int bytesRead = input.read(buffer);
                // String message = new String(buffer, 0, bytesRead);

                // OutputStream output = socket.getOutputStream();
                // output.write(("Thank you for connecting!").getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}