import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11222_SocketServer_A07 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Handle client connection here, for example, you can create a new thread for each connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_11222_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client data here
        // For simplicity, we'll just read a line of text from the socket and echo it back
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);
            System.out.println("Received message: " + message);

            socket.getOutputStream().write(("Echo: " + message).getBytes());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}