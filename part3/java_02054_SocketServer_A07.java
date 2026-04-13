import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02054_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for handling the client request
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind to port " + PORT);
            System.exit(-1);
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_02054_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle request and response here
        // For example, just echo back any received message
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write("Echo: ".getBytes());
                socket.getOutputStream().write(socket.getInputStream().read());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}