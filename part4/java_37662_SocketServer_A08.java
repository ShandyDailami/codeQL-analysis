import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37662_SocketServer_A08 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle communication
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_37662_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from client
            byte[] buffer = new byte[1024];
            int bytes = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytes);

            System.out.println("Received: " + message);

            // Send a response
            String response = "Server received your message: " + message;
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}