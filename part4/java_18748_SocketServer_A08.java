import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18748_SocketServer_A08 {
    private static final int DEFAULT_PORT = 1234;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted connection from " + client.getRemoteSocketAddress());
                new HandleClientThread(client).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + port + ". Reason: " + e.getMessage());
       
            // If port is busy, it will be returned to the operating system and
            // another attempt will be made.
            // We can't truly fix the problem without changing the underlying system.
            System.exit(-1);
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_18748_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we can implement the logic for handling client communication.
            // This is a dummy implementation, where we just echo back the client's message.
            // You can replace this with your actual implementation.
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Client disconnected");
                    break;
                }
                socket.getOutputStream().write(buffer, 0, bytesRead);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            System.err.println("Failed to handle client connection. Reason: " + e.getMessage());
        }
    }
}