import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28341_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
       
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_28341_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the request in this thread
        try {
            // Get input and output streams from the socket
            // Here we're assuming a simple echo protocol
            // All requests are received on one side and the response is sent back on the other side
            String request = new String(socket.getInputStream().readNBytes(1024));
            String response = "Echo: " + request;

            socket.getOutputStream().writeBytes(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}