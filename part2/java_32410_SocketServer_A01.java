import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32410_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    private java_32410_SocketServer_A01() {
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Process the new socket in a new thread
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            startServer(DEFAULT_PORT); // Try again in case the port is not available
        }
    }

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }
}

class HandlerThread extends Thread {
    private Socket socket;

    public java_32410_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the socket in a secure way, e.g. use SSL/TLS

        // For simplicity, we'll just close the socket after processing
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}