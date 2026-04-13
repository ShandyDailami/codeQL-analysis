import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39232_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT + "...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected!");

            // Here we're not using a thread for this connection, but if we did we'd be using a thread.
            // This is just a simple example and doesn't include any form of error handling or security.
            // It also doesn't include a mechanism for receiving data or sending it back, but that's a basic example.
            // For a real-world application, you'd likely want to use a thread and a thread pool for efficiency.
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_39232_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here we're not doing anything with the socket, but if we did we'd be using a stream to read from and write to the socket.
        // This is just a simple example and doesn't include any form of error handling or security.
        // It also doesn't include a mechanism for receiving data or sending it back, but that's a basic example.
        // For a real-world application, you'd likely want to use a stream and a buffer for efficiency.
    }
}