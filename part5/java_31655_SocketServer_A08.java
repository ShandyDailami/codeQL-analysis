import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31655_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + ".");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_31655_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new buffer for incoming data
            byte[] buffer = new byte[1024];

            // Read the incoming data from the client
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead == -1) {
                // No bytes were readable from the client. Close the connection.
                socket.close();
            } else {
                // The client sent data. Now, we need to send data back to the client.
                // We'll use a simple string to demonstrate.
                String response = "Server received your message.";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            // An error occurred. Close the connection.
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}