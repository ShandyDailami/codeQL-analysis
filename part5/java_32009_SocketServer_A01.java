import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32009_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Handle the client connection in a new thread
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_32009_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here, e.g., read/write data
        // ...

        // Close the client connection
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}