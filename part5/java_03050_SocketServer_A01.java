import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03050_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03050_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read request from client
            socket.getInputStream().read();

            // Check if the client is connecting to localhost and port 12345
            if (socket.getRemoteSocketAddress().equals(socket.getLocalSocketAddress()) && socket.getPort() == 12345) {
                System.out.println("Connection accepted");
            } else {
                System.out.println("Connection declined, not allowed");
                socket.getOutputStream().write("HTTP/1.1 403 Forbidden\r\n".getBytes());
                socket.close();
            }

            socket.getOutputStream().write("HTTP/1.1 200 OK\r\n".getBytes());
            socket.getOutputStream().write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
            socket.getOutputStream().write("\r\n".getBytes());
            socket.getOutputStream().write("Hello, World!".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}