import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33207_SocketServer_A01 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ServerThread(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class ServerThread implements Runnable {
    private Socket socket;

    public java_33207_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // This will be a lot of work for a real-world server, but this will serve as a minimalist style example
        try {
            while (true) {
                // Read a message from the client
                // This is a very simplistic example, you would want to read more data and handle more than one message at a time
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);

                System.out.println("Received: " + message);

                // Send a response back to the client
                // This is a very simplistic example, you would want to send more data and handle more than one response at a time
                socket.getOutputStream().write(("Response: " + message).getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            System.out.println("Error handling client connection: " + e.getMessage());
        }
    }
}