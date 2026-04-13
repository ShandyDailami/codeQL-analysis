import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15088_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // port number is arbitrary
            System.out.println("Server is running on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // waits for client to connect
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // handle client communication
                new ClientHandler(socket).start(); // start a new thread for each client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles communication with a single client
    static class ClientHandler extends Thread {
        private Socket socket;

        public java_15088_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // read from client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) return; // client disconnected

                String message = new String(buffer, 0, bytesRead); // convert bytes to string
                System.out.println("Received: " + message);

                // write to client
                String response = "Hello client, you connected to port 8080";
                byte[] responseBytes = response.getBytes();
                socket.getOutputStream().write(responseBytes);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}