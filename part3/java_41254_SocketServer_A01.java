import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41254_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
        System.out.println("Server started on port " + port + ".");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected.");

            // Handle client connection in a separate thread
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_41254_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client connection, close the socket and exit thread
        // This is a very basic example and does not include any security-sensitive operations
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}