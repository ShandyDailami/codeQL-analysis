import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11512_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Authentication
            if (authenticate(socket)) {
                new ClientHandler(socket).start();
            } else {
                System.out.println("Authentication failed, closing connection");
                socket.close();
            }
        }
    }

    private static boolean authenticate(Socket socket) {
        // Assume we have a method to read from the socket and authenticate
        // Here we are just checking if the username and password match
        return socket.getInputStream().readUTF().equals(USERNAME) &&
                socket.getOutputStream().readUTF().equals(PASSWORD);
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_11512_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Handle client's requests
                while (true) {
                    String message = socket.getInputStream().readUTF();
                    System.out.println("Received: " + message);

                    // For the sake of simplicity, we'll just echo back the message
                    socket.getOutputStream().writeUTF(message);
                    socket.getOutputStream().flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}