import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37927_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            // Accept a new client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Handle the client connection in a new thread
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_37927_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Receive a message from the client
        byte[] buffer = new byte[1024];
        socket.getInputStream().read(buffer);
        String message = new String(buffer);
        System.out.println("Received message: " + message);

        // Send a response back to the client
        socket.getOutputStream().write("ACK from server".getBytes());
        socket.getOutputStream().flush();
        System.out.println("Sent message: ACK from server");
    }
}