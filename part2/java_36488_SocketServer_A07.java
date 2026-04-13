import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36488_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Server port
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");

                // Handle the client connection
                // This is a simple example and should be modified to handle multiple clients
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_36488_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client's request
        // This is a simple example and should be modified to handle multiple requests
        try {
            // Read request from client
            // Modify this to read from the client's request
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String request = new String(buffer);

            // Send response to client
            // Modify this to send a response to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}